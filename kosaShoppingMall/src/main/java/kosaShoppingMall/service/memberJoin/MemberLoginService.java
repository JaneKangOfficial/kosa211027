package kosaShoppingMall.service.memberJoin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.LoginCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class MemberLoginService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String execute(LoginCommand loginCommand, BindingResult result, HttpSession session) {
		String path = "thymeleaf/index";
		
		AuthInfo authInfo = memberMapper.loginSelect(loginCommand.getUserId());
		if(authInfo != null) {
			if(passwordEncoder.matches(loginCommand.getUserPw(), authInfo.getUserPw())) {
				session.setAttribute("authInfo", authInfo);
				path = "redirect:/";
			}else {
				result.rejectValue("userPw", "loginCommand.userPw", "비밀번호 다릅니다.");
			}
		}else {
			result.rejectValue("userId", "loginCommand.userId", "아이디가 존재하지 않습니다.");
		}
		return path;
	}
}
