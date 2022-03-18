package school.controller;

import javax.servlet.http.HttpSession;

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
import school.domain.AuthInfo;
import school.service.check.ProfessorEmailCkService;
import school.service.check.ProfessorEmailCkUpdateService;
import school.service.check.ProfessorIdCkService;
import school.service.check.ProfessorIdCkUpdateService;
import school.service.department.DepartmentListService;
import school.service.professor.MySubListService;
import school.service.professor.ProfessorDelService;
import school.service.professor.ProfessorInfoService;
import school.service.professor.ProfessorListService;
import school.service.professor.ProfessorMyInfoService;
import school.service.professor.ProfessorNumService;
import school.service.professor.ProfessorRegistService;
import school.service.professor.ProfessorUpdateService;
import school.service.professor.SubCancelService;
import school.service.professor.SubCloseService;
import school.service.professor.SubDelService;
import school.service.professor.SubDelService2;
import school.service.professor.SubDeletesService;
import school.service.professor.SubInService;
import school.service.professor.SubInfoService;
import school.service.professor.SubInsertListService;
import school.service.professor.SubInsertOneService;
import school.service.professor.SubInsertService;

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
	@Autowired
	ProfessorEmailCkUpdateService professorEmailCkUpdateService;
	@Autowired
	ProfessorIdCkUpdateService professorIdCkUpdateService;
	@Autowired
	ProfessorMyInfoService professorMyInfoService;
	@Autowired
	SubInsertService subInsertService;
	@Autowired
	SubInsertOneService subInsertOneService;
	@Autowired
	SubInsertListService subInsertListService;
	@Autowired
	SubDelService subDelService;
	@Autowired
	SubInfoService subInfoService;
	@Autowired
	SubDelService2 subDelService2;
	@Autowired
	SubDeletesService subDeletesService;
	@Autowired
	SubInService subInService;
	@Autowired
	MySubListService mySubListService;
	@Autowired
	SubCancelService subCancelService;
	@Autowired
	SubCloseService subCloseService;
	
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
	public String professorRegist(@Validated ProfessorCommand professorCommand, BindingResult result, Model model, HttpSession session) {
		
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
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo == null) {
			return "redirect:/";
		}else {
			return "redirect:professorList";
		}
	}
	
	@RequestMapping("professorInfo/{num}")
	public String professorInfo(@PathVariable(value="num") String professorNum, Model model, HttpSession session) {
		professorInfoService.execute(professorNum, model, session);
		return "professor/proInfo";
	}
	
//	@PathVariable은 get방식으로 한번만 쓸 때만 사용하기!
	@RequestMapping("proUpdate")
	public String profUpdate(@RequestParam(value="num") String professorNum, Model model, HttpSession session) {
		professorInfoService.execute(professorNum, model, session);
		departmentListService.execute(model);
		return "professor/proUpdate"; 
	}
	
	@RequestMapping(value="proUpdate", method=RequestMethod.POST)
	public String proUpdate(@Validated ProfessorCommand professorCommand, BindingResult result, Model model, HttpSession session) {
		professorNumService.execute(model);
		departmentListService.execute(model);
		
		Integer i = professorEmailCkUpdateService.execute(professorCommand.getProfessorEmail(), session);
		if(i == 1) {
			return "professor/proUpdate";
		}
		Integer ii = professorIdCkUpdateService.execute(professorCommand.getProfessorId(), session);
		if(ii == 1) {
			return "professor/proUpdate";
		}
		
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

	@RequestMapping("myInfo")
	public String myInfo(HttpSession session, Model model) {
		professorMyInfoService.execute(session, model);
		return "professor/myInfo";
	}
	
	@RequestMapping("subInsertList")
	public String subInsertList(Model model) {
		subInsertListService.execute(model);
		return "professor/subInsertList";
	}
	
	@RequestMapping("subInsert")
	public String subInsert(@RequestParam(value="subjectNum[]") String[] subjectNum, HttpSession session) {
		System.out.println("111111subjectNum " + subjectNum);
		subInsertService.execute(subjectNum, session);
		return "redirect:subInsertList";
	}
	
	@RequestMapping("subInsertOne/{num}")
	public String subInsertOne(@PathVariable(value="num") String subjectNum, HttpSession session) {
		String path = subInsertOneService.execute(subjectNum, session);
		return path;
	}
	
	@RequestMapping("subIn")
	public String subIn(@RequestParam(value="subIn") String[] subIn, HttpSession session) {
		subInService.execute(subIn, session);
		return "redirect:subInsertList";
	}
	
	@RequestMapping("subInfo")
	public String subInfo(@RequestParam(value="num") String professorNum, @RequestParam(value="num2") String subjectNum, Model model, HttpSession session) {
		subInfoService.execute(professorNum, subjectNum, model, session);
		return "professor/subInfo";
	}
	
	@RequestMapping("subDel")
	public String subDel(@RequestParam(value="num") String subjectNum) {
		subDelService.execute(subjectNum);
		return "redirect:subInsertList";
	}
	
	@RequestMapping("subDel2")
	public String subDel2(@RequestParam(value="num") String professorNum, @RequestParam(value="num2") String subjectNum, HttpSession session) {
		subDelService2.execute(professorNum, subjectNum, session);
		return "redirect:subInsertList";
	}
	
	@RequestMapping(value="subDeletes", method = RequestMethod.POST)
	public String subDeletes(@RequestParam(value="delete") String[] deletes, HttpSession session) {
		subDeletesService.execute(deletes, session);
		return "redirect:subInsertList";
	}
	
	@RequestMapping(value="mySubDeletes", method = RequestMethod.POST)
	public String mySubDeletes(@RequestParam(value="delete") String[] deletes, HttpSession session) {
		subDeletesService.execute(deletes, session);
		return "redirect:mySubList";
	}
	
	@RequestMapping("mySubList")
	public String mySubList(HttpSession session, Model model) {
		mySubListService.execute(session, model);
		return "professor/mySubList";
	}
	
	@RequestMapping("subClose") 
	public String subClose(@RequestParam(value="num") String professorNum, @RequestParam(value="num2") String subjectNum, HttpSession session) {
		subCloseService.execute(professorNum, subjectNum, session);
		return "redirect:subInfo?num="+professorNum+"&num2="+subjectNum;
	}
	
	@RequestMapping("subCancel") 
	public String subCancel(@RequestParam(value="num") String professorNum, @RequestParam(value="num2") String subjectNum, HttpSession session) {
		subCancelService.execute(professorNum, subjectNum, session);
		return "redirect:subInfo?num="+professorNum+"&num2="+subjectNum;
	}
}
