package com.ssg.potato.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssg.potato.domain.Auction;

public class AuctionValidator implements Validator {
	
	public AuctionValidator() {

	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Auction.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Auction auction = (Auction)object;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auction.title", "required", "상품명은 필수입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auction.content", "required", "상품 설명은 필수입력 사항입니다.");

		int price = auction.getPrice();
		if (price == 0) {
			errors.rejectValue("auction.price", "required", "가격은 필수입력 사항입니다.");
		} else if (price < 0)  {
			errors.rejectValue("auction.price", "required", "양수를 입력하십시오.");
		} else if (price < 100) {
			errors.rejectValue("auction.price", "required", "100원 이상부터 등록 가능합니다.");
		}

		int auctionPrice = auction.getAuctionPrice();
		if (auctionPrice == 0) {
			errors.rejectValue("auction.auctionPrice", "required", "입찰 단위는 필수입력 사항입니다.");
		} else if(auctionPrice < 0)  {
			errors.rejectValue("auction.auctionPrice", "required", "양수를 입력하십시오.");
		} else if (auctionPrice < 100) {
			errors.rejectValue("auction.auctionPrice", "required", "100원 이상부터 등록 가능합니다.");
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		String today_date = format.format(cal.getTime());

		Date end_date = auction.getEnd_date();
		String fm_end = format.format(end_date);

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

		if (end_date == null) {
			errors.rejectValue("auction.end_date", "required", "경매 종료일은 필수입력 사항입니다.");
		} else if (today.after(end) || today.equals(end)) {
			errors.rejectValue("auction.end_date", "required", "경매 종료일은 오늘 날짜 이후를 선택하셔야 합니다.");
		}
	}
}
