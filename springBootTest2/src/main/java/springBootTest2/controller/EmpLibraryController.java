package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.service.empLib.EmpLibDelService;
import springBootTest2.service.empLib.EmpLibInfoService;
import springBootTest2.service.empLib.EmpLibInsertService;
import springBootTest2.service.empLib.EmpLibListService;
import springBootTest2.service.empLib.EmpLibUpdateService;

@Controller
@RequestMapping("empLib")
public class EmpLibraryController {
	@Autowired
	EmpLibInsertService empLibInsertService;
	@Autowired
	EmpLibListService empLibListService;
	@Autowired
	EmpLibInfoService empLibInfoService;
	@Autowired
	EmpLibUpdateService empLibUpdateService;
	@Autowired
	EmpLibDelService empLibDelService;
	
	@RequestMapping("libList")
	public String libList(Model model) {
		empLibListService.execute(model);
		return "thymeleaf/empLib/empLibList";
	}
	
	@RequestMapping("libForm")
	public String libForm() {
		return "thymeleaf/empLib/empLibForm";
	}
	
	@RequestMapping("EMPLibWrite")
	public String libWrite(EmpLibCommand empLibCommand, HttpServletRequest request) {
		empLibInsertService.execute(empLibCommand, request);
		return "redirect:libList";
	}
	
	@RequestMapping("libInfo")
	public String libInfo(@RequestParam(value="num") Integer libNum, Model model) {
		empLibInfoService.execute(libNum, model);
		return "thymeleaf/empLib/empLibInfo";
	}
	
	@RequestMapping("libUpdate")
	public String libUpdate(@RequestParam(value="num") Integer libNum, Model model) {
		empLibInfoService.execute(libNum, model);
		return "thymeleaf/empLib/empLibUpdate";
	}
	
	@RequestMapping("libUpdateOk")
	public String libUpdateOk(EmpLibCommand empLibCommand, HttpServletRequest request, Model model) {
		String path = empLibUpdateService.execute(empLibCommand, request, model);
		return path;
	}
	
	@RequestMapping("libDelete")
	public String libDelete(@RequestParam(value="num") Integer libNum, Model model) {
		model.addAttribute("aaa", libNum);
		return "thymeleaf/empLib/empLibDelPass";
	}
	
	@RequestMapping("libDeleteOk")
	public String libDelete(EmpLibCommand empLibCommand, Model model, HttpSession session) {
		String path = empLibDelService.execute(empLibCommand, model, session);
		return path;
	}
}
