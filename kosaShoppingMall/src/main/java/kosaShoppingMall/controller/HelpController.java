package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kosaShoppingMall.command.FindIdCommand;
import kosaShoppingMall.service.help.FindIdService;

@Controller
@RequestMapping("help")
public class HelpController {
	@Autowired
	FindIdService findIdService;
	
	@RequestMapping(value="findId", method=RequestMethod.GET)
	public String findId(FindIdCommand findIdCommand) {
		return "thymeleaf/help/findId";
	}
	
	@RequestMapping(value="findId", method=RequestMethod.POST)
	public String findIdOk(@Validated FindIdCommand findIdCommand, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "thymeleaf/help/findId";
		}
		
		// 등록한 전화번호, 이메일이 아닐 경우, if ~ else 사용 : 두가지 주소로 return
		String path = findIdService.execute(findIdCommand, result, model);
		return path;
		//return "thymeleaf/help/findId1"; command는 model이 값을 저장하지 않아도 값을 가지고 있다면 무조건 값을 출력할 수 있다.
	}
	
}
