package school.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import school.command.LoginCommand;


@Controller
public class MainController {

	@RequestMapping(value="/")
	public String main(LoginCommand loginCommand) {
		return "thymeleaf/index";
	}
}
