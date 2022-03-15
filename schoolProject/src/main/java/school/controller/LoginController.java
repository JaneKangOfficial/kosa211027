package school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import school.command.LoginCommand;
import school.service.login.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login/loginPro", method = RequestMethod.POST)
	public String login(@Validated LoginCommand loginCommand, HttpSession session, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("login index error 발생");
			return "thymeleaf/index";
		}
		String path = loginService.execute(loginCommand, session, result);
		return path;
	}
	
	@RequestMapping("login/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
