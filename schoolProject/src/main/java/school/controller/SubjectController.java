package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.SubjectCommand;
import school.service.subject.SubjectDelService;
import school.service.subject.SubjectInfoService;
import school.service.subject.SubjectListService;
import school.service.subject.SubjectNumService;
import school.service.subject.SubjectRegistService;
import school.service.subject.SubjectUpdateService;

@Controller
@RequestMapping("subject")
public class SubjectController {
	@Autowired
	SubjectNumService subjectNumService;
	@Autowired
	SubjectRegistService subjectRegistService;
	@Autowired
	SubjectListService subjectListService;
	@Autowired
	SubjectInfoService subjectInfoService;
	@Autowired
	SubjectUpdateService subjectUpdateService;
	@Autowired
	SubjectDelService subjectDelService;
	
	@RequestMapping("subList")
	public String subList(@RequestParam(value="page", defaultValue = "1", required = false) Integer page, Model model) {
		subjectListService.execute(model, page);
//		return "subject/subList";
		return "thymeleaf/subject/subList";
	}
	
	@RequestMapping("subRegist")
	public String subRegist1(Model model) {
		subjectNumService.execute(model);
		return "subject/subForm";
//		return "thymeleaf/subject/subForm";
	}
	
	@RequestMapping(value="subRegist", method=RequestMethod.POST)
	public String subRegist(SubjectCommand subjectCommand) {
		subjectRegistService.execute(subjectCommand);
		return "redirect:subList";
	}
	
	@RequestMapping("subInfo/{num}")
	public String subInfo(@PathVariable(value="num") String subjectNum, Model model) {
		subjectInfoService.execute(subjectNum, model);
		return "subject/subInfo";
//		return "thymeleaf/subject/subInfo";
	}
	
	@RequestMapping("subUpdate/{num}")
	public String subUpdate1(@PathVariable(value="num") String subjectNum, Model model) {
		subjectInfoService.execute(subjectNum, model);
		return "subject/subUpdate";
//		return "thymeleaf/subject/subUpdate";
	}
	
	@RequestMapping(value="subUpdate", method=RequestMethod.POST)
	public String subUpdate(SubjectCommand subjectCommand) {
		subjectUpdateService.execute(subjectCommand);
		return "redirect:subInfo/"+subjectCommand.getSubjectNum();
	}
	
	@RequestMapping("subDel/{num}")
	public String subUpdate(@PathVariable(value="num") String subjectNum) {
		subjectDelService.execute(subjectNum);
		return "redirect:../subList";
	}
	
}
