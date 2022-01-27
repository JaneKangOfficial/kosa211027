package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.service.member.MemberDeleteService;
import kosaShoppingMall.service.member.MemberInfoService;
import kosaShoppingMall.service.member.MemberInsertService;
import kosaShoppingMall.service.member.MemberListService;
import kosaShoppingMall.service.member.MemberUpdateService;

@Controller
@RequestMapping("mem")
public class MemberController {
	@Autowired
	MemberInsertService memberInsertService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@Autowired
	MemberDeleteService memberDeleteService;

	@RequestMapping("memList")
	public String memList(Model model) {
		memberListService.execute(model);
		return "thymeleaf/member/memberList";
	}
	
	@RequestMapping(value="memberRegist", method=RequestMethod.GET)
	public String memberForm1() {
		return "thymeleaf/member/memberForm";
	}
	
	@RequestMapping(value="memberRegist", method=RequestMethod.POST)
	public String memberForm(MemberCommand memberCommand) {
		if(!memberCommand.isEmpPwEqualsEmpPwCon()) {
			return "thymeleaf/member/memberForm";
		}
		memberInsertService.execute(memberCommand);
		return "redirect:memList";
	}
	
	@RequestMapping("memberInfo")
	public String memberInfo(@RequestParam(value="num") String memberNum, Model model){
		memberInfoService.execute(memberNum, model);
		return "thymeleaf/member/memberInfo";
	}
	
	@RequestMapping(value="memModify", method=RequestMethod.GET)
	public String memModify(@RequestParam(value="num") String memberNum, Model model) {
		memberInfoService.execute(memberNum, model);
		return "thymeleaf/member/memberUpdate";
	}
	
	@RequestMapping(value="memModify", method=RequestMethod.POST)
	public String memModify(MemberCommand memberCommand) {
		memberUpdateService.execute(memberCommand);
		return "redirect:memberInfo?num="+memberCommand.getMemberNum();
	}
	
	@RequestMapping("memDelete")
	public String memDelete(@RequestParam(value="num") String memberNum) {
		memberDeleteService.execute(memberNum);
		return "redirect:memList";
	}
}
