package kosaShoppingMall.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.service.member.MemberInfoService;

@Controller
public class JsonController {
	@Autowired
	MemberInfoService memberInfoService;
	
	@RequestMapping(value="jsonMain")
	public String jsonMain() {
		return "thymeleaf/json/jsonMain";
	}

	@RequestMapping("json1")
	public String json1() {
		return "thymeleaf/json/jsonTest";
	}

	@RequestMapping("ajax")
	public void ajaxView(@RequestParam("id") String id, HttpServletResponse response, Model model) {
		response.setCharacterEncoding("utf-8");
		String personJson;
		MemberDTO member = memberInfoService.execute(id, model);
		
		if(member != null) {
			personJson = "{\"memberName\": \"" + member.getMemberName() + "\",\"memberAddr\": \"" + member.getMemberAddr()+ "\"}";
			System.out.println("personJson : " + personJson);
		}else {
			personJson = "null";
		}
		
		try {
			response.getWriter().print(personJson);
		}catch(Exception e) {}
	}
	
	@RequestMapping("json2")
	public String json2() {
		return "thymeleaf/json/jsonTest1";
	}
	
	@RequestMapping("ajax1")
	public void ajax1(@RequestParam("id") String id, HttpServletResponse response, Model model) {
		ObjectMapper mapper = new ObjectMapper();
		MemberDTO member = memberInfoService.execute(id, model);
		response.setCharacterEncoding("utf-8");
		
		try {
			// ObjectMapper는 알아서 값을 JSON 형태로 만들어주기 때문에 작성하지 않아도 된다.
			response.getWriter().print(mapper.writeValueAsString(member)); 
		}catch(Exception e) {}
	}
	
	@RequestMapping("json3")
	public String json3() {
		return "thymeleaf/json/jsonTest2";
	}
	
	@RequestMapping("ajax2")
	public @ResponseBody MemberDTO ajaxView2(@RequestParam("id") String id, HttpServletResponse response, Model model) {
		MemberDTO member = memberInfoService.execute(id, model);
		return member;
	}
	
	@RequestMapping("json4")
	public String json4() {
		return "thymeleaf/json/jsonTest3";
	}
	
	@RequestMapping(value="/ajax3")
	public ModelAndView ajax3(@RequestParam("id") String id, Model model) {
		// ModelAndView : 여러가지 값을 날릴 수 있음 => 회사에서 주로 사용!
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView"); // WebConfig.java 에 @Bean(name="jsonView") 작성 
		// 1. memberCommand 값만 날아감
//		memberInfoService.execute(id, model);
		
		// 2. memberCommand가 들어있는 member를 날리기 때문에 memberCommand, member 두 값이 모두 출력됨
		MemberDTO member = memberInfoService.execute(id, model);
		mav.addObject("member", member);
		
		return mav;
	}

}
