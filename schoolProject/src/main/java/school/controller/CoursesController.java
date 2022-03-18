package school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.CoursesSubjectCommand;
import school.service.courses.ClasesListService;
import school.service.courses.ClassSubjectService;
import school.service.courses.CoursesDelService;
import school.service.courses.CoursesInfoService;
import school.service.courses.CoursesInsertService;
import school.service.courses.CoursesListService;
import school.service.courses.ProfessorListService2;

@Controller
@RequestMapping("courses")
public class CoursesController {
	@Autowired
	ClasesListService clasesListService;
	@Autowired
	ClassSubjectService classSubjectService;
	@Autowired
	ProfessorListService2 professorListService2;
	@Autowired
	CoursesInsertService coursesInsertService;
	@Autowired
	CoursesListService coursesListService;
	@Autowired
	CoursesDelService coursesDelService;
	@Autowired
	CoursesInfoService coursesInfoService;

	@RequestMapping("coursesCheck")
	public String courses(Model model) {
		clasesListService.execute(model);
		coursesListService.execute(model);
		return "thymeleaf/courses/coursesList";
	}
	
	@RequestMapping("classSubject")
	public String classSubject(@RequestParam(value="departmentNum") String departmentNum, HttpSession session, Model model) {
		classSubjectService.execute(departmentNum, session, model);
		return "thymeleaf/courses/classSubject";
	}
	
	@RequestMapping("professorList")
	public String professorList(@RequestParam(value="subjectNum") String subjectNum, Model model) {
		professorListService2.execute(subjectNum, model);
		return "thymeleaf/courses/professorList";
	}
	
	@RequestMapping("coursesInsert")
	public String coursesInsert(CoursesSubjectCommand coursesSubjectCommand, HttpSession session) {
		coursesInsertService.execute(coursesSubjectCommand, session);
		return "redirect:coursesCheck";
	}
	
	@RequestMapping("coursesDel")
	public String coursesDel(@RequestParam(value="delete") String[] delete) {
		coursesDelService.execute(delete);
		return "redirect:coursesCheck";
	}
	
	@RequestMapping("coursesInfo")
	public String coursesInfo(CoursesSubjectCommand coursesSubjectCommand, Model model) {
		coursesInfoService.execute(coursesSubjectCommand, model);
		return "thymeleaf/courses/coursesInfo";
	}
	
}
