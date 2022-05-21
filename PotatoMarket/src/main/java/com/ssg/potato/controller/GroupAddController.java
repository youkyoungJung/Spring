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

import com.ssg.potato.service.GroupService;
import com.ssg.potato.service.GroupValidator;

@Controller
@RequestMapping({"/add/group", "/edit/group"})
@SessionAttributes("groupForm")
public class GroupAddController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GroupAddController.class);

	@Value("groupForm")
	private String formViewName;

	@Value("group")
	private String successViewName;

	private GroupService service;

	@Autowired
	public void setGroupService(GroupService service) {
		this.service = service;
	}

	@GetMapping
	public String showForm() {
		logger.info("그룹 폼 열림");
		return formViewName;
	}

	@ModelAttribute("groupForm")
	public GroupForm formBacking(@RequestParam("group_id") int group_id, HttpServletRequest request) {
		logger.info("그룹 폼 배킹");
		if (group_id != 0) {
			logger.info("수정");
			return new GroupForm(service.selectGroup(group_id));

		} else {
			logger.info("추가");
			return new GroupForm();

		}
	}

	@PostMapping
	public String onSubmit(
			HttpServletRequest request, 
			HttpSession session, 
			@ModelAttribute("groupForm") GroupForm form,
			ModelMap model, 
			BindingResult result, 
			@RequestPart MultipartFile files, 
			SessionStatus sessionStatus
			) throws Exception {
		String id = UserSession.getLoginMemberId(session);
		int group_id = 0;
		
		new GroupValidator().validate(form.getGroup(), result);

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

			form.getGroup().setFileName(destinationFileName);
			if (form.isNewGroup()) {
				service.insert(form.getGroup(), id);
				group_id = service.selectGroupId(id);
				logger.info("공구 폼 추가");
			} else {
				service.update(form.getGroup());
				group_id = form.getGroup().getGroup_id();
				logger.info("공구 폼 수정");
			}
		} catch (

				DataIntegrityViolationException ex) {
			result.rejectValue("group.group_id", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName;
		}
		sessionStatus.setComplete();

		return "redirect:/detail/group?group_id=" + group_id;
	}
}