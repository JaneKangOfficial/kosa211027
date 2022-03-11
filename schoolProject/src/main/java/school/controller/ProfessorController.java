package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.ProfessorCommand;
import school.service.check.ProfessorEmailCkService;
import school.service.check.ProfessorIdCkService;
import school.service.department.DepartmentListService;
import school.service.professor.ProfessorDelService;
import school.service.professor.ProfessorInfoService;
import school.service.professor.ProfessorListService;
import school.service.professor.ProfessorNumService;
import school.service.professor.ProfessorRegistService;
import school.service.professor.ProfessorUpdateService;

@Controller
@RequestMapping("professor")
public class ProfessorController {
	@Autowired
	ProfessorNumService professorNumService;
	@Autowired
	DepartmentListService departmentListService;
	@Autowired
	ProfessorRegistService professorRegistService;
	@Autowired
	ProfessorListService professorListService;
	@Autowired
	ProfessorInfoService professorInfoService;
	@Autowired
	ProfessorUpdateService professorUpdateService;
	@Autowired
	ProfessorDelService professorDelService;
	@Autowired
	ProfessorEmailCkService professorEmailCkService;
	@Autowired
	ProfessorIdCkService professorIdCkService;
	
	
	@ModelAttribute
	ProfessorCommand setProfessorCommand() {
		return new ProfessorCommand();
	}

	@RequestMapping("professorList")
	public String professorList(Model model) {
		professorListService.execute(model);
		return "professor/proList";
	}
	
	@RequestMapping("professorRegist")
	public String professorRegist(Model model) {
		professorNumService.execute(model);
		departmentListService.execute(model);
		return "professor/proForm";
	}
	
	@RequestMapping(value="professorRegist", method=RequestMethod.POST)
	public String professorRegist(@Validated ProfessorCommand professorCommand, BindingResult result, Model model ) {
		
		Integer i = professorEmailCkService.execute(professorCommand.getProfessorEmail());
		if(i == 1) {
			return "professor/proForm";
		}
		Integer ii = professorIdCkService.execute(professorCommand.getProfessorId());
		if(ii == 1) {
			return "professor/proForm";
		}
		
		if(result.hasErrors()) {
			professorNumService.execute(model);
			departmentListService.execute(model);
			return "professor/proForm";
		}
		
		if(!professorCommand.passwordCon()) {
			professorNumService.execute(model);
			departmentListService.execute(model);
			result.rejectValue("professorPw", "professorCommand.professorPw", "비밀번호 확인이 일치하지 않습니다.");
			return "professor/proForm";
		}
		
		professorRegistService.execute(professorCommand);
		return "redirect:professorList";
	}
	
	@RequestMapping("professorInfo/{num}")
	public String professorInfo(@PathVariable(value="num") String professorNum, Model model) {
		professorInfoService.execute(professorNum, model);
		return "professor/proInfo";
	}
	
//	@PathVariable은 get방식으로 한번만 쓸 때만 사용하기!
	@RequestMapping("proUpdate")
	public String profUpdate(@RequestParam(value="num") String professorNum, Model model) {
		professorInfoService.execute(professorNum, model);
		departmentListService.execute(model);
		return "professor/proUpdate"; 
	}
	
	@RequestMapping(value="proUpdate", method=RequestMethod.POST)
	public String proUpdate(@Validated ProfessorCommand professorCommand, BindingResult result, Model model) {
		professorNumService.execute(model);
		departmentListService.execute(model);
		
		if(result.hasErrors()) {
			return "professor/proUpdate";
		}
		
		String path = professorUpdateService.execute(professorCommand, result, model);
		return path;
	}
	
	@RequestMapping("proDel/{num}")
	public String proDel(@PathVariable(value="num") String professorNum) {
		professorDelService.execute(professorNum);
		return "redirect:../professorList";
	}
	
}
