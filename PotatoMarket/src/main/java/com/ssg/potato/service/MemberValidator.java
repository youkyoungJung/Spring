package com.ssg.potato.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ssg.potato.domain.Member;

public class MemberValidator implements Validator{

	public MemberValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		Member member = (Member)object;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "이름은 필수입력 사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "member_id", "required", "아이디 필수입력 사항입니다.");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "이메일은 필수입력 사항입니다.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "required", "비밀번호는 필수입력 사항입니다.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw2", "required", "비밀번호확인은 필수입력 사항입니다.");
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tel", "required", "전화번호는 필수입력 사항입니다.");
        
        if (member.hasPassword()) {
			if (member.getPw().length() < 3)
				errors.rejectValue("pw", "shortPassword" ,"비밀번호는 3자리수 이상입니다.");
			else if (!member.isSamePasswordConfirmPassword())
				errors.rejectValue("pw2", "notSame" ,"비밀번호가 같지 않습니다.");
		}
        
        String tel = member.getTel();
		if (tel == null || tel.trim().isEmpty()) {
			errors.rejectValue("tel", "required","전화번호는 필수입력 사항입니다.");
		}
		else {
			if (tel.matches("01[01679]-\\d{3,4}-\\d{4}") == false)
				errors.rejectValue("tel", "invalidFormat" ,"01x-xxxx-xxxx형태로 입력바랍니다.");	
		}

		String email = member.getEmail();
		if(email == null || email.trim().isEmpty()) {
			errors.rejectValue("email", "required","이메일은 필수입력 사항입니다.");
		}
		else {
			if (email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}") == false)
				errors.rejectValue("email", "invalidFormat" ,"you@example.com형태로 입력바랍니다.");	
		}
	}

}
