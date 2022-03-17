package school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import school.service.check.DepNumSelectService;
import school.service.check.ProfessorEmailCkService;
import school.service.check.ProfessorEmailCkUpdateService;
import school.service.check.ProfessorIdCkService;
import school.service.check.ProfessorIdCkUpdateService;
import school.service.check.StudentEmailCkService;
import school.service.check.StudentEmailCkUpdateService;
import school.service.check.StudentIdCkService;
import school.service.check.StudentIdCkUpdateService;

@RestController 
public class CkController {
	@Autowired
	ProfessorEmailCkService professorEmailCkService;
	@Autowired
	ProfessorIdCkService professorIdCkService;
	@Autowired
	StudentIdCkService studentIdCkService;
	@Autowired
	StudentEmailCkService studentEmailCkService;
	@Autowired
	ProfessorEmailCkUpdateService professorEmailCkUpdateService;
	@Autowired
	ProfessorIdCkUpdateService professorIdCkUpdateService;
	@Autowired
	StudentIdCkUpdateService studentIdCkUpdateService;
	@Autowired
	StudentEmailCkUpdateService studentEmailCkUpdateService;
	@Autowired
	DepNumSelectService depNumSelectService;
	
	@RequestMapping("/professor/emailCk")
	public String emailck(@RequestParam(value = "email") String email) {
		Integer i = professorEmailCkService.execute(email);
		if(i == 0) {
			return "사용 가능한 이메일입니다.";
		}else {
			return "사용 불가능한 이메일입니다";
		}
	}
	@RequestMapping("/professor/emailCkUpdate")
	public String emailCkUpdate(@RequestParam(value = "email") String email, HttpSession session) {
		Integer i = professorEmailCkUpdateService.execute(email, session);
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
	@RequestMapping("/professor/idCkUpdate")
	public String idCkUpdate(@RequestParam(value = "id") String id, HttpSession session) {
		Integer i = professorIdCkUpdateService.execute(id, session);
		if(i == 0) {
			return "사용 가능한 아이디입니다.";
		}else {
			return "사용 불가능한 아이디입니다";
		}
	}
	
	@RequestMapping("/student/idCk")
	public String studentIdCk(@RequestParam(value="id") String id) {
		Integer i = studentIdCkService.execute(id);
		if(i == 0) {
			return "사용 가능한 아이디입니다.";
		}else {
			return "사용 불가능한 아이디입니다";
		}
	}
	@RequestMapping("/student/idCkUpdate")
	public String studentIdCkUpdate(@RequestParam(value="id") String id, HttpSession session) {
		Integer i = studentIdCkUpdateService.execute(id, session);
		if(i == 0) {
			return "사용 가능한 아이디입니다.";
		}else {
			return "사용 불가능한 아이디입니다";
		}
	}
	
	@RequestMapping("/student/emailCk")
	public String studentEmailCk(@RequestParam(value="email") String email) {
		Integer i = studentEmailCkService.execute(email);
		if(i == 0) {
			return "사용 가능한 이메일입니다.";
		}else {
			return "사용 불가능한 이메일입니다";
		}
	}
	@RequestMapping("/student/emailCkUpdate")
	public String studentEmailCkUpdate(@RequestParam(value="email") String email, HttpSession session) {
		Integer i = studentEmailCkUpdateService.execute(email, session);
		if(i == 0) {
			return "사용 가능한 이메일입니다.";
		}else {
			return "사용 불가능한 이메일입니다";
		}
	}
	
	@RequestMapping("/student/depNum")
	public String depNum(@RequestParam(value="depNum") String departmentNum) {
		return depNumSelectService.execute(departmentNum);
	}
}
