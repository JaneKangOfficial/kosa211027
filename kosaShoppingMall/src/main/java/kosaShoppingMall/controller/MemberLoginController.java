package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kosaShoppingMall.command.LoginCommand;
import kosaShoppingMall.service.memberJoin.MemberLoginService;

@Controller
public class MemberLoginController {
	@Autowired
	MemberLoginService memberLoginService;
	@ModelAttribute
	LoginCommand setLoginCommand() {
		return new LoginCommand();
	}

	@RequestMapping(value="loginPro", method = RequestMethod.GET)
	public String home() {
		return "redirect:/";
	}
	
	@RequestMapping(value="loginPro", method = RequestMethod.POST)
	public String loginPro(@Validated LoginCommand loginCommand, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/index";
		}
		
		String path = memberLoginService.execute(loginCommand, result, session);
		return path;
	}
	
	@RequestMapping("/main/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
