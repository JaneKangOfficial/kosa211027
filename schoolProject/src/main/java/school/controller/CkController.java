package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import school.service.check.ProfessorEmailCkService;
import school.service.check.ProfessorIdCkService;

@RestController
public class CkController {
	@Autowired
	ProfessorEmailCkService professorEmailCkService;
	@Autowired
	ProfessorIdCkService professorIdCkService;
	
	@RequestMapping("/professor/emailCk")
	public String emailck(@RequestParam(value = "email")String email) {
		Integer i = professorEmailCkService.execute(email);
		if(i == 0) {
			return "사용 가능한 이메일입니다.";
		}else {
			return "사용 불가능한 이메일입니다";
		}
	}
	
	@RequestMapping("/professor/idCk")
	public String idCk(@RequestParam(value = "id") String id) {
		Integer i = professorIdCkService.execute(id);
		if(i == 0) {
			return "사용 가능한 아이디입니다.";
		}else {
			return "사용 불가능한 아이디입니다";
		}
	}
}
