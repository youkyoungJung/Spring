package com.ssg.potato.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
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

import com.ssg.potato.service.ItemService;
import com.ssg.potato.service.ItemValidator;

@Controller
@RequestMapping({ "/add/item", "/edit/item" })
@SessionAttributes("itemForm")
public class ItemAddController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ItemAddController.class);

	@Value("itemForm")
	private String formViewName;

	@Value("item")
	private String successViewName;

	private ItemService service;

	@Autowired
	public void setItemService(ItemService service) {
		this.service = service;
	}

	@GetMapping
	public String showForm() {
		logger.info("회원간 폼 열림");
		return formViewName;
	}

	@ModelAttribute("itemForm")
	public ItemForm formBacking(@RequestParam("item_id") int item_id, HttpServletRequest request) {
		logger.info("회원간 폼 배킹");
		if (item_id != 0) {
			logger.info("수정");
			return new ItemForm(service.selectItem(item_id));

		} else {
			logger.info("추가");
			return new ItemForm();

		}
	}

	@PostMapping
	public String onSubmit(
			HttpServletRequest request, 
			HttpSession session, 
			@ModelAttribute("itemForm") ItemForm form,
			@RequestPart MultipartFile files, 
			ModelMap model, 
			BindingResult result, 
			SessionStatus sessionStatus
			) throws Exception {
		String id = UserSession.getLoginMemberId(session);
		int item_id = 0;

		new ItemValidator().validate(form.getItem(), result);
		
		if (result.hasErrors())
			return formViewName;
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

			form.getItem().setFileName(destinationFileName);
			if (form.isNewItem()) {
				service.insert(form.getItem(), id);
				item_id = service.selectItemId(id);
				logger.info("회원간 폼 추가");
			} else {
				item_id = form.getItem().getItem_id();
				service.update(form.getItem());
				logger.info("회원간 폼 수정");
			}
		} catch (

				DataIntegrityViolationException ex) {
			result.rejectValue("group.group_id", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName;
		}
		sessionStatus.setComplete();

		return "redirect:/detail/item?item_id=" + item_id;
	}
}
