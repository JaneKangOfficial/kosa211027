package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginCommand {

	@NotBlank(message = "아이디 입력!!!")
	String userId;
	@NotBlank(message = "비밀번호 입력!!!")
	String userPw;
}
