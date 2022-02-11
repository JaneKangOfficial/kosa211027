package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kosaShoppingMall.service.EmailCheckService;
import kosaShoppingMall.service.IdCheckService;
import kosaShoppingMall.service.employees.EmpEmailCheckService;
import kosaShoppingMall.service.employees.EmpIdCheckService;
import kosaShoppingMall.service.member.MemberEmailCheckService;
import kosaShoppingMall.service.member.MemberIdCheckService;

@RestController
public class CheckController {
	@Autowired
	IdCheckService idCheckService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	EmpIdCheckService empIdCheckService;
	@Autowired
	EmpEmailCheckService empEmailCheckService;
	@Autowired
	MemberIdCheckService memberIdCheckService;
	@Autowired
	MemberEmailCheckService memberEmailCheckService;
	
	@RequestMapping(value="/register/idCheck", method=RequestMethod.POST)
	public String idCheck(@RequestParam(value="memberId") String memberId) {
		
		Integer i = idCheckService.execute(memberId);
		if(i == 0) {
			return "사용 가능한 id입니다.";
		}else {
			return "사용 중인 id입니다.";
		}
	}
	
	@RequestMapping(value="/register/emailCheck", method=RequestMethod.POST)
	public String emailCheck(@RequestParam(value="memberEmail") String memberEmail ) {
		Integer i = emailCheckService.execute(memberEmail);
		if(i == 0) {
			return "사용 가능한 email입니다.";
		}else {
			return "사용 중인 email입니다.";
		}
	}
	
	@RequestMapping(value="/emp/empIdCheck", method=RequestMethod.POST)
	public String empIdCheck(@RequestParam(value="empId") String empId) {
		
		Integer i = empIdCheckService.execute(empId);
		
		if(i == 0) {
			return "사용 가능한 id입니다.";
		}else {
			return "사용 중인 id입니다.";
		}
	}
	
	@RequestMapping(value="/emp/empEmailCheck", method=RequestMethod.POST)
	public String empEmailCheck(@RequestParam(value="empEmail") String empEmail) {
		Integer i = empEmailCheckService.execute(empEmail);
		if(i == 0) {
			return "사용 가능한 email입니다.";
		}else {
			return "사용 중인 email입니다.";
		}
	}
	
	@RequestMapping(value="/empMypage/empEmailCheck", method=RequestMethod.POST)
	public String empEmailCheck2(@RequestParam(value="empEmail") String empEmail) {
		Integer i = empEmailCheckService.execute(empEmail);
		if(i == 0) {
			return "사용 가능한 email입니다.";
		}else {
			return "사용 중인 email입니다.";
		}
	}
	
	@RequestMapping(value="/mem/memIdCheck", method=RequestMethod.POST)
	public String memIdCheck(@RequestParam(value="memberId") String memberId) {
		Integer i = memberIdCheckService.execute(memberId);
		if(i == 0) {
			return "사용 가능한 id입니다.";
		}else {
			return "사용 중인 id입니다.";
		}
	}
	
	@RequestMapping(value="/mem/memEmailCheck", method=RequestMethod.POST)
	public String memEmailCheck(@RequestParam(value="memberEmail") String memberEmail) {
		Integer i = memberEmailCheckService.execute(memberEmail);
		if(i == 0) {
			return "사용 가능한 email입니다.";
		}else {
			return "사용 중인 email입니다.";
		}
	}
	
	@RequestMapping(value="/mypage/memEmailCheck", method=RequestMethod.POST)
	public String memEmailCheck2(@RequestParam(value="memberEmail") String memberEmail) {
		Integer i = memberEmailCheckService.execute(memberEmail);
		if(i == 0) {
			return "사용 가능한 email입니다.";
		}else {
			return "사용 중인 email입니다.";
		}
	}
	
}
