package com.ssg.potato.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssg.potato.domain.Group;

public class GroupValidator implements Validator {

	public GroupValidator() {

	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Group.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object object, Errors errors) {
		Group group = (Group)object;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "group.title", "required", "상품명은 필수입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "group.content", "required", "상품 설명은 필수입력 사항입니다.");

		int price = group.getPrice();
		if (price == 0) {
			errors.rejectValue("group.price", "required", "가격은 필수입력 사항입니다.");
		} else if (price < 0)  {
			errors.rejectValue("group.price", "required", "양수를 입력하십시오.");
		} else if (price < 100) {
			errors.rejectValue("group.price", "required", "100원 이상부터 입력 가능합니다.");
		}
		
		int maxPeople = group.getMaxPeople();
		if (maxPeople == 0) {
			errors.rejectValue("group.maxPeople", "required", "최대 인원은 필수입력 사항입니다.");
		} else if (maxPeople < 0)  {
			errors.rejectValue("group.maxPeople", "required", "양수를 입력하십시오.");
		} else if (maxPeople < 2) {
			errors.rejectValue("group.maxPeople", "required", "2명 이상부터 등록 가능합니다.");
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		String today_date = format.format(cal.getTime());

		Date endDate = group.getEndDate();
		String fm_end = format.format(endDate);

		Date today = null;
		Date end = null;
		try {
			today = (Date) format.parse(today_date);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		try {
			end = (Date) format.parse(fm_end);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		if (endDate == null) {
			errors.rejectValue("group.endDate", "required", "마감일은 필수입력 사항입니다.");
		} else if (today.after(end) || today.equals(end)) {
			errors.rejectValue("group.endDate", "required", "마감일은 오늘 날짜 이후를 선택하셔야 합니다.");
		}
	}
}

