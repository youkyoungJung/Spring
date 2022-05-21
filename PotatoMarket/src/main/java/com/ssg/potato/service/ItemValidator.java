package com.ssg.potato.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssg.potato.domain.Item;

public class ItemValidator implements Validator {

	public ItemValidator() {

	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Item item = (Item)object;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.title", "required", "상품명은 필수입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.content", "required", "상품 설명은 필수입력 사항입니다.");

		int price = item.getPrice();
		if (price == 0) {
			errors.rejectValue("item.price", "required", "가격은 필수입력 사항입니다.");
		} else if (price < 0)  {
			errors.rejectValue("item.price", "required", "양수를 입력하십시오.");
		} else if (price < 100) {
			errors.rejectValue("item.price", "required", "100원 이상부터 입력 가능합니다.");
		}		
	}
}
