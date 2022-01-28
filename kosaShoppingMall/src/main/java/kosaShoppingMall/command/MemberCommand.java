package kosaShoppingMall.command;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {
	@Size(min = 10, max = 10, message = "번호 입력!!!")
	String memberNum;
	@NotBlank(message = "아이디 입력!!!")
	@Size(min = 3, max = 20)
	String memberId;
	@NotBlank(message="비밀번호 입력!!!")
	String memberPw;
	@NotBlank(message="비밀번호 확인 입력!!!")
	String memberPwCon;
	@NotBlank(message="이름 입력!!!")
	String memberName;
	@NotBlank(message="주소 입력!!!")
	String memberAddr;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="등록일 입력하여 주세요.")
	Date memberRegist;
	@NotBlank(message="성별 입력!!!")
	String gender;
	@NotBlank(message="연락처 입력!!!")
	String memberPhone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="생일을 입력하여 주세요.")
	Date memberBirth;
	@Email(message = "이메일 형식!!!")
	@NotBlank(message="이메일 입력!!!")
	String memberEmail;
	
	public boolean isEmpPwEqualsEmpPwCon() {
		return memberPw.equals(memberPwCon);
	}
}
