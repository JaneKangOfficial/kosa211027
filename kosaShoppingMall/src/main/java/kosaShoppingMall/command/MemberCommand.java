package kosaShoppingMall.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {
	String memberNum;
	String memberId;
	String memberPw;
	String memberPwCon;
	String memberName;
	String memberAddr;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberRegist;
	String gender;
	String memberPhone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberBirth;
	String memberEmail;
	
	public boolean isEmpPwEqualsEmpPwCon() {
		return memberPw.equals(memberPwCon);
	}
}
