package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.service.member.MemberJoinService;
import kosaShoppingMall.service.member.MemberNumService;

@Controller
@RequestMapping("register")
public class MemberJoinController {
	
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberNumService memberNumService;
	
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
	public String regist(@RequestParam(value="agree", defaultValue = "false") Boolean agree, MemberCommand memberCommand) {
		System.out.println(agree);
		
		if(agree == false) {
			return "thymeleaf/membership/agree";
		}
		
		memberNumService.execute(memberCommand);
		return "thymeleaf/membership/memberJoinForm";
	}
	
	@RequestMapping("memberJoinAction")
	public String joinAction(@Validated MemberCommand memberCommand, BindingResult result) {

		if(result.hasErrors()) {
			return "thymeleaf/membership/memberJoinForm";
		}
		
		if(!memberCommand.isEmpPwEqualsEmpPwCon()) {
			result.rejectValue("memberPwCon", "memberCommand.memberPwCon", "비밀번호 확인이 일치하지 않습니다.");
			return "thymeleaf/membership/memberJoinForm";
		}
		memberJoinService.execute(memberCommand);
		return "redirect:/";
	}
}
