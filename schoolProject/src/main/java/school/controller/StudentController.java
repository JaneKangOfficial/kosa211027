package school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.StudentCommand;
import school.domain.AuthInfo;
import school.service.check.StudentEmailCkService;
import school.service.check.StudentEmailCkUpdateService;
import school.service.check.StudentIdCkService;
import school.service.check.StudentIdCkUpdateService;
import school.service.department.DepartmentNumSelectService;
import school.service.student.StudentDelService;
import school.service.student.StudentInfoService;
import school.service.student.StudentListService;
import school.service.student.StudentMyInfoService;
import school.service.student.StudentRegistService;
import school.service.student.StudentUpdateService;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentRegistService studentRegistService;
	@Autowired
	StudentListService studentListService;
	@Autowired
	DepartmentNumSelectService departmentNumSelectService;
	@Autowired
	StudentInfoService studentInfoService;
	@Autowired
	StudentUpdateService studentUpdateService;
	@Autowired
	StudentDelService studentDelService;
	@Autowired
	StudentEmailCkService studentEmailCkService;
	@Autowired
	StudentIdCkService studentIdCkService;
	@Autowired
	StudentEmailCkUpdateService studentEmailCkUpdateService;
	@Autowired
	StudentIdCkUpdateService studentIdCkUpdateService;
	@Autowired
	StudentMyInfoService studentMyInfoService;

	@RequestMapping("studentList")
	public String studentList(@RequestParam(value="page", defaultValue = "1", required = false) Integer page, Model model) {
		studentListService.execute(page, model);
		return "student/studentList";
	}
	
	@RequestMapping("studentRegist")
	public String studentRegist(Model model) {
		departmentNumSelectService.execute(model);
		return "student/studentForm";
	}
	
	@RequestMapping(value="studentRegist", method = RequestMethod.POST)
	public String studentRegist(@Validated StudentCommand studentCommand, BindingResult result, Model model, HttpSession session) {
		departmentNumSelectService.execute(model);

		Integer i = studentEmailCkService.execute(studentCommand.getStudentEmail());
		if(i == 1) {
			return "student/studentForm";
		}
		Integer ii = studentIdCkService.execute(studentCommand.getStudentId());
		if(ii == 1) {
			return "student/studentForm";
		}
		
		if(result.hasErrors()) {
			return "student/studentForm"; 
		}
		if(!studentCommand.pwCon()) {
			result.rejectValue("studentPw", "studentCommand.studentPw", "비밀번호 확인이 일치하지 않습니다.");
			return "student/studentForm"; 
		}
		
		studentRegistService.execute(studentCommand);
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo == null) {
			return "redirect:/";
		}else {
			return "redirect:studentList";
		}
	}
	
	@RequestMapping("studentInfo")
	public String studentInfo(@RequestParam(value="num") String studentNum, Model model, HttpSession session) {
		studentInfoService.execute(studentNum, model, session);
		return "student/studentInfo"; 
	}
	
	@RequestMapping(value="studentUpdate", method = RequestMethod.GET)
	public String studentUpdate(@RequestParam(value="num") String studentNum, Model model, HttpSession session) {
		studentInfoService.execute(studentNum, model, session);
		departmentNumSelectService.execute(model);
		return "student/studentUpdate"; 
	}
	
	@RequestMapping(value="studentUpdate", method = RequestMethod.POST)
	public String studentUpdate(StudentCommand studentCommand, BindingResult result, Model model, HttpSession session) {
		departmentNumSelectService.execute(model);

		Integer i = studentEmailCkUpdateService.execute(studentCommand.getStudentEmail(), session);
		if(i == 1) {
			return "student/studentUpdate";
		}
		Integer ii = studentIdCkUpdateService.execute(studentCommand.getStudentId(), session);
		if(ii == 1) {
			return "student/studentUpdate";
		}
		
		if(result.hasErrors()) {
			return "student/studentUpdate"; 
		}
		if(!studentCommand.newPwCon()) {
			result.rejectValue("newPw", "studentCommand.newPw", "비밀번호 확인이 일치하지 않습니다.");
			return "student/studentUpdate"; 
		}
		
		String path = studentUpdateService.execute(studentCommand, result, session);
		return path;
	}
	
	@RequestMapping("studentDel")
	public String studentDel(@RequestParam(value="num") String studentNum) {
		studentDelService.execute(studentNum);
		return "redirect:studentList";
	}
	
	@RequestMapping("myInfo")
	public String myInfo(HttpSession session, Model model) {
		studentMyInfoService.execute(session, model);
		return "student/myInfo";
	}
}
