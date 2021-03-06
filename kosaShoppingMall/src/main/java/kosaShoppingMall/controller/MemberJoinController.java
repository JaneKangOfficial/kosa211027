package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.service.EmailCheckService;
import kosaShoppingMall.service.IdCheckService;
import kosaShoppingMall.service.member.MemberNumService;
import kosaShoppingMall.service.memberJoin.MemberJoinService;
import kosaShoppingMall.service.memberJoin.MemberMailService;

@Controller
@RequestMapping("register")
public class MemberJoinController {
	
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberNumService memberNumService;
	@Autowired
	IdCheckService idCheckService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	MemberMailService memberMailService;
	
	@ModelAttribute
	public MemberCommand setMemberCommand() {
		return new MemberCommand();
	}

	@RequestMapping(value="agree", method = RequestMethod.GET)
	public String agree() {
		return "thymeleaf/membership/agree";
	}
	
	@RequestMapping(value="regist", method = RequestMethod.GET)
	public String regist1() {
		return "thymeleaf/membership/agree";
	}
	
	@RequestMapping(value="regist", method = RequestMethod.POST)
	public String regist(@RequestParam(value="agree", defaultValue = "false") Boolean agree, MemberCommand memberCommand, Model model) {
		System.out.println(agree);
		
		if(agree == false) {
			return "thymeleaf/membership/agree";
		}
		
		memberNumService.execute(memberCommand, model);
		return "thymeleaf/membership/memberJoinForm";
	}
	
	@RequestMapping("memberJoinAction")
	public String joinAction(@Validated MemberCommand memberCommand, BindingResult result, Model model) {

		if(result.hasErrors()) {
			return "thymeleaf/membership/memberJoinForm";
		}
		
		if(!memberCommand.isEmpPwEqualsEmpPwCon()) {
			result.rejectValue("memberPwCon", "memberCommand.memberPwCon", "???????????? ????????? ???????????? ????????????.");
			return "thymeleaf/membership/memberJoinForm";
		}
		
		Integer i = idCheckService.execute(memberCommand.getMemberId());
		if(i == 1) {
			result.rejectValue("memberId", "memberCommand.memberId", "?????? ??????????????????.");
			return "thymeleaf/membership/memberJoinForm";
		}
		
		i = emailCheckService.execute(memberCommand.getMemberEmail());
		if(i == 1) {
			result.rejectValue("memberEmail", "memberCommand.memberEmail", "?????? ??????????????????.");
			return "thymeleaf/membership/memberJoinForm";
		}
		memberJoinService.execute(memberCommand, model);
		return "thymeleaf/membership/welcome";
	}
	
	@RequestMapping("memberMail")
	public String memberMail(@RequestParam(value="num") String num, 
						@RequestParam(value="reciver") String reciver,
						@RequestParam(value="userId") String userId) {
	
		Integer i = memberMailService.execute(num, reciver, userId);
		if(i > 0) {
			return "thymeleaf/membership/success";
		}else {
			return "thymeleaf/membership/fail";
		}
	}
	
}
