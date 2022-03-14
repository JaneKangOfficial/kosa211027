package school.service.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import school.command.LoginCommand;
import school.domain.AuthInfo;
import school.mapper.StudentMapper;

@Service
public class LoginService {
	@Autowired
	StudentMapper studentMapper;	
	@Autowired
	PasswordEncoder passwordEncoder;

	public void execute(LoginCommand loginCommand, HttpSession session, BindingResult result, Model model) {
		
		AuthInfo authInfo = studentMapper.loginSelect(loginCommand.getUserId());
		
		if(authInfo != null) {
			if(passwordEncoder.matches(loginCommand.getUserPw(), authInfo.getUserPw())) {
				session.setAttribute("authInfo", authInfo);
			}else {
				result.rejectValue("userPw", "loginCommand.userPw", "비밀번호 다릅니다.");
			}
		}else {
			result.rejectValue("userId", "loginCommand.userId", "아이디가 존재하지 않습니다.");
		}
		model.addAttribute("authInfo", authInfo);
	}
}
