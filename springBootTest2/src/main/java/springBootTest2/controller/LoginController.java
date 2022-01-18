package springBootTest2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.service.login.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/loginPro", method=RequestMethod.GET)
	public String home() {
		return "redirect:/";
	}
	
	@RequestMapping(value="/loginPro", method=RequestMethod.POST)
	public String loginPro(@RequestParam(value="id") String id, 
			@RequestParam(value="pw") String pw, HttpSession session, Model model) {
		String path = loginService.execute(id, pw, session, model);
		return path;
		// model 값을 전달하기 위해서는 꼭 html 페이지가 열려야 한다.
		// redirect는 model 값 전달이 안된다.
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
}
