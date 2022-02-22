package kosaShoppingMall.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kosaShoppingMall.command.LoginCommand;
import kosaShoppingMall.service.goods.GoodsListPageService;
import kosaShoppingMall.service.memberJoin.MemberLoginService;

@Controller
public class MemberLoginController {
	@Autowired
	MemberLoginService memberLoginService;
	@Autowired
	GoodsListPageService goodsListPageService;
	
	@ModelAttribute
	LoginCommand setLoginCommand() {
		return new LoginCommand();
	}

	@RequestMapping(value="/login/loginPro", method = RequestMethod.GET)
	public String home() {
		return "redirect:/";
	}
	
	@RequestMapping(value="/login/loginPro", method = RequestMethod.POST)
	public String loginPro(@Validated LoginCommand loginCommand, BindingResult result, 
						HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		if(result.hasErrors()) {
			goodsListPageService.execute(request);
			return "thymeleaf/index";
		}
		
		String path = memberLoginService.execute(loginCommand, result, session, request, response);
		return path;
	}
	
	@RequestMapping("/login/logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		// 무조건 session 전에 쿠키 삭제!
		Cookie cookie = new Cookie("autoLogin", ""); // cookie(name,value)
		cookie.setPath("/"); // 쿠키 저장경로
		cookie.setMaxAge(0); // 쿠키 삭제
		response.addCookie(cookie); // 사용자에게 전달
		
		session.invalidate();
		return "redirect:/";
	}
}
