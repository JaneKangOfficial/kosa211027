package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.service.member.MemberDeleteService;
import kosaShoppingMall.service.member.MemberNumService;
import kosaShoppingMall.service.mypage.DelService;
import kosaShoppingMall.service.mypage.DetailService;
import kosaShoppingMall.service.mypage.ModifyService;
import kosaShoppingMall.service.mypage.PwUpdateService;

@Controller
@RequestMapping("mypage")
public class MemberMypageController {
	@Autowired
	DetailService detailService;
	@Autowired
	MemberNumService memberNumService;
	@Autowired
	ModifyService modifyService;
	@Autowired
	PwUpdateService pwUpdateService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	DelService delService;
 
	@ModelAttribute
	public MemberCommand setMemberCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping("memberDetail")
	public String memberDetail(HttpSession session, Model model) {
		detailService.execute(session, model);
		return "thymeleaf/membership/memberDetail";
	}
	
	@RequestMapping(value="memberPw", method = RequestMethod.GET)
	public String memberPw(HttpSession session, Model model) {
		detailService.execute(session, model);
		return "thymeleaf/membership/memberModify";
	}
	
	@RequestMapping(value="memberModify", method = RequestMethod.POST)
	public String memberModify(@Validated MemberCommand memberCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/membership/memberModify";
		}
		
		String path = modifyService.execute(memberCommand, result);
		return path;
	}
	
	@RequestMapping(value="memberPwForm", method=RequestMethod.GET)
	public String memberPwForm(HttpSession session, Model model) {
		detailService.execute(session, model);
		return "thymeleaf/membership/memberPwUpdate";
	}
	
	@RequestMapping(value="memberPwForm", method=RequestMethod.POST)
	public String memberPwForm(MemberCommand memberCommand, Model model) {
		String path = pwUpdateService.execute(memberCommand, model);
		return path;
	}
	
	@RequestMapping(value="memberUserDel", method=RequestMethod.GET)
	public String memberUserDel(HttpSession session, Model model) {
		detailService.execute(session, model);
		return "thymeleaf/membership/memberDelPw";
	}
	
	@RequestMapping(value="memberUserDel", method = RequestMethod.POST)
	public String memberUserDel(MemberCommand memberCommand, HttpSession session) {
		String path = delService.execute(memberCommand, session);
		return path;
	}
	
}
