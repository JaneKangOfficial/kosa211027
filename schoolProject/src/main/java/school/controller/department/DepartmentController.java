package school.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import school.command.DepartmentCommand;
import school.service.department.DepartmentDelService;
import school.service.department.DepartmentInfoService;
import school.service.department.DepartmentListService;
import school.service.department.DepartmentNumService;
import school.service.department.DepartmentRegistService;
import school.service.department.DepartmentUpdateService;

@Controller
@RequestMapping("major")
public class DepartmentController {
	@Autowired
	DepartmentRegistService departmentRegistService;
	@Autowired
	DepartmentNumService departmentNumService;
	@Autowired
	DepartmentListService departmentListService;
	@Autowired
	DepartmentInfoService departmentInfoService;
	@Autowired
	DepartmentUpdateService departmentUpdateService;
	@Autowired
	DepartmentDelService departmentDelService;
	
	@RequestMapping("majorList")
	public String majorList(Model model) {
		departmentListService.execute(model);
		return "thymeleaf/department/majorList";
	}
	
	@RequestMapping("majorRegist")
	public String majorRegist(Model model) {
		departmentNumService.execute(model);
		return "thymeleaf/department/majorRegist";
	}
	
	@RequestMapping(value="departmentRegist" , method=RequestMethod.POST)
	public String departmentRegist(DepartmentCommand departmentCommand) {
		departmentRegistService.execute(departmentCommand);
		return "redirect:majorList";
	}
	
	@RequestMapping("departmentUpdate")
	public String departmentUpdate1(@RequestParam(value="num") String departmentNum, Model model) {
		departmentInfoService.execute(departmentNum, model);
		return "thymeleaf/department/majorUpdate";
	}
	
	@RequestMapping(value="departmentUpdate", method = RequestMethod.POST)
	public String departmentUpdate(DepartmentCommand departmentCommand) {
		departmentUpdateService.execute(departmentCommand);
		return "redirect:majorList";
	}
	
	@RequestMapping(value="departmentDel", method = RequestMethod.POST)
	public String departmentDel(@RequestParam(value="num")String departmentNum , Model model) {
		departmentDelService.execute(departmentNum , model);
		return "thymeleaf/department/delete";
	}

}
