package springBootTest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.MemberCommand;
import springBootTest2.service.member.MemberDelService;
import springBootTest2.service.member.MemberInfoService;
import springBootTest2.service.member.MemberListService;
import springBootTest2.service.member.MemberNumberService;
import springBootTest2.service.member.MemberUpdateSerivce;
import springBootTest2.service.member.MemberWriteService;

@Controller
@RequestMapping("mem") // 관리자 페이지
public class MemberController {
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberNumberService memberNumberService;
	@Autowired
	MemberWriteService memberWriteService;
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberDelService memberDelService;
	@Autowired
	MemberUpdateSerivce memberUpdateSerivce;

	@RequestMapping("memberList")
	public String memberList(Model model) {
		memberListService.execute(model);
		return "thymeleaf/mem/memberList";
	}
	
	@RequestMapping("memberRegist")
	public String memberRegist(Model model) {
		memberNumberService.execute(model);
		return "thymeleaf/mem/memberForm";
	}
	
	@RequestMapping("memberWrite")
	public String memberWrite(MemberCommand memberCommand, Model model) {
		memberWriteService.execute(memberCommand, model);
		return "thymeleaf/mem/welcome";
	}
	
	@RequestMapping("memberDetail")
	public String memberDetail(@RequestParam(value="num") String memNum, Model model) {
		memberInfoService.execute(memNum, model);
		return "thymeleaf/mem/memberInfo";
	}
	
	@RequestMapping("memberDel")
	public String memberDel(@RequestParam(value="num") String memNum) {
		memberDelService.execute(memNum);
		return "redirect:memberList";
	}
	
	@RequestMapping("memberUpdate")
	public String memberUpdate(@RequestParam(value="num") String memNum, Model model) {
		memberInfoService.execute(memNum, model);
		return "thymeleaf/mem/memberUpdate";
	}
	
	@RequestMapping("memberModify")
	public String memberModify(MemberCommand memberCommand) {
		memberUpdateSerivce.execute(memberCommand);
		return "redirect:memberDetail?num="+memberCommand.getMemNum();
	}
	
}
