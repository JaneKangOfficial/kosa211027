package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.service.member.MemberDeleteService;
import kosaShoppingMall.service.member.MemberDelsService;
import kosaShoppingMall.service.member.MemberInfoService;
import kosaShoppingMall.service.member.MemberInsertService;
import kosaShoppingMall.service.member.MemberListService;
import kosaShoppingMall.service.member.MemberNumService;
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
	@Autowired
	MemberNumService memberNumService;
	@Autowired
	MemberDelsService memberDelsService;

	@ModelAttribute
	MemberCommand setMemberCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping("memList")
	public String memList(Model model) {
		memberListService.execute(model);
		return "thymeleaf/member/memberList"; // html 사용
		//return "member/memberList"; // jsp 사용
	}
	
	@RequestMapping(value="memberRegist", method=RequestMethod.GET)
	public String memberForm1(MemberCommand memberCommand, Model model) {
		memberNumService.execute(memberCommand, model);
		//return "thymeleaf/member/memberForm"; // html, command 사용 - spring boot
		return "member/memberForm"; // jsp, model 사용 - spring
	}
	
	@RequestMapping(value="memberRegist", method=RequestMethod.POST)
	public String memberForm(@Validated MemberCommand memberCommand, BindingResult result) {
		if(result.hasErrors()) {
			//return "thymeleaf/member/memberForm";
			return "member/memberForm";
		}
		
		if(!memberCommand.isEmpPwEqualsEmpPwCon()) {
			result.rejectValue("memberPw", "memberCommand.memberPw", "비밀번호 확인이 일치하지 않습니다.");
			//return "thymeleaf/member/memberForm";
			return "member/memberForm";
		}
		memberInsertService.execute(memberCommand);
		return "redirect:memList";
	}
	
	// @PathVariable 은 {id}
	// {id}도 주소이기 때문에 "/"로 구별
	@RequestMapping("memberInfo/{id}")
	public String memberInfo(@PathVariable(value="id") String memberNum, Model model){
		memberInfoService.execute(memberNum, model);
		//return "thymeleaf/member/memberInfo";
		return "member/memberInfo";
	}
	
	@RequestMapping(value="memModify", method=RequestMethod.GET)
	public String memModify(@RequestParam(value="num") String memberNum, Model model) {
		memberInfoService.execute(memberNum, model);
		//return "thymeleaf/member/memberUpdate";
		return "member/memberUpdate";
	}
	
	@RequestMapping(value="memModify", method=RequestMethod.POST)
	public String memModify(@Validated MemberCommand memberCommand, BindingResult result) {
		// Validated 검사시 result.hasErrors 사용해서 error 확인하기!
		if(result.hasErrors()) {
			//return "thymeleaf/member/memberForm";
			return "member/memberForm";
		}
		memberUpdateService.execute(memberCommand);
		return "redirect:memberInfo/"+memberCommand.getMemberNum();
//		return "redirect:memberInfo?num="+memberCommand.getMemberNum();
	}
	
	@RequestMapping("memDelete")
	public String memDelete(@RequestParam(value="num") String memberNum, Model model) {
		memberDeleteService.execute(memberNum, model);
		//return "redirect:memList";
		// ajax 사용시 redirect는 사용할 수 없다. next page(.html)가 필요하다.
		//return "thymeleaf/member/memberDel";
		return "member/memberDel";
	}
	
	@RequestMapping(value="memDels", method=RequestMethod.POST)
	public String memDels(@RequestParam(value="delete") String[] deletes) {
		memberDelsService.execute(deletes);
		return "redirect:memList";
	}
}
