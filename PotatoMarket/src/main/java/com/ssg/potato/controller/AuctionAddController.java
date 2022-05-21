package com.ssg.potato.controller;

import java.io.File;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.ssg.potato.service.AuctionService;
import com.ssg.potato.service.AuctionValidator;
import com.ssg.potato.service.BidService;

@Controller
@RequestMapping({"/add/auction", "/edit/auction"})
@SessionAttributes("auctionForm")
public class AuctionAddController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AuctionAddController.class);

	@Value("auctionForm")
	private String formViewName;

	@Value("auction")
	private String successViewName;

	private AuctionService service;

	private BidService bid;

	@Autowired
	public void setAuctionService(AuctionService service) {
		this.service = service;
	}

	@Autowired
	public void setBidService(BidService service) {
		this.bid = service;
	}

	@GetMapping
	public String showForm() {
		logger.info("경매 폼 열림");
		return formViewName;
	}

	@ModelAttribute("auctionForm")
	public AuctionForm formBacking(
			@RequestParam("auction_id") int auction_id, 
			HttpServletRequest request) {
		logger.info("경매 폼 배킹");
		if (auction_id != 0) { 
			logger.info("경매 수정");
			return new AuctionForm(service.selectAuction(auction_id));
		} else {
			logger.info("경매 추가");
			return new AuctionForm();
		}
	}

	@PostMapping
	public String onSubmit(
			HttpServletRequest request, 
			HttpSession session,
			@ModelAttribute("auctionForm") AuctionForm form,
			ModelMap model, 
			BindingResult result,
			@RequestPart MultipartFile files,
			HttpServletResponse response,
			SessionStatus sessionStatus
			) throws Exception {

		String id = UserSession.getLoginMemberId(session);
		int auction_id = 0;
			
		new AuctionValidator().validate(form.getAuction(), result);

		if (result.hasErrors()) {
			return formViewName;
		}
			
		try {
			String fileName = files.getOriginalFilename();
			String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
			File destinationFile;
			String destinationFileName;
			String root_path = request.getSession().getServletContext().getRealPath("/");  
			
			String fileUrl = root_path.replace("webapp\\","resources\\static\\images\\");

			do {
				destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
				destinationFile = new File(fileUrl + destinationFileName);
			} while (destinationFile.exists());

			destinationFile.getParentFile().mkdirs();
			files.transferTo(destinationFile);

			logger.info("fileName" + destinationFileName);

			form.getAuction().setFileName(destinationFileName);
			if (form.isNewAuction()) {
				service.insert(form.getAuction(), id);
				auction_id = service.selectAuctionId(id);
				logger.info("경매 폼 추가");
			} else {
				auction_id = form.getAuction().getAuction_id();
				if (bid.dataCountBidCheck(auction_id) == 0) { // 입찰자가 존재하지 않을 경우에만 수정.
					auction_id = form.getAuction().getAuction_id();
					service.update(form.getAuction());
					logger.info("경매 폼 수정");
				} else {
					logger.info("입찰자가 존재하므로 수정 불가.");
					response.setContentType("text/html; charset=UTF-8"); 
					RequestDispatcher dispatcher = request.getRequestDispatcher( "/list/auction" );
					dispatcher.include( request, response );
					response.getWriter().write("<script> alert('※ 경고 : 입찰자가 존재하는 상품은 수정되지 않음을 알립니다.'); </script>");
					response.getWriter().flush();
					return null;
				}
			}
		} catch (DataIntegrityViolationException ex) {
			result.rejectValue("auction_id", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName; 
		}
		sessionStatus.setComplete();
		return "redirect:/detail/auction?auction_id=" + auction_id;
	}
}
