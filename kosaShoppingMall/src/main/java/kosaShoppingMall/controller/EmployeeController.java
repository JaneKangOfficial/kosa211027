package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.service.employees.EmployeeDeleteService;
import kosaShoppingMall.service.employees.EmployeeInfoService;
import kosaShoppingMall.service.employees.EmployeeListService;
import kosaShoppingMall.service.employees.EmployeePassChangService;
import kosaShoppingMall.service.employees.EmployeePassUpdateService;
import kosaShoppingMall.service.employees.EmployeeUpdateService;
import kosaShoppingMall.service.employees.EmployeesWriteService;

@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmployeesWriteService employeeWriteService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeInfoService employeeInfoService;
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@Autowired
	EmployeePassUpdateService employeePassUpdateService;
	@Autowired
	EmployeePassChangService employeePassChangService;
	
	
	@RequestMapping("empList")
	public String empList(Model model) {
		employeeListService.execute(model);
		return "thymeleaf/employee/empList";
	}
	
	@RequestMapping("empJoin")
	public String empJoin() {
		return "thymeleaf/employee/empForm";
	}
	
	@RequestMapping(value="empWrite", method=RequestMethod.GET)
	public String empWrite1() {
		return "thymeleaf/employee/empForm";
	}
	
	@RequestMapping(value="empWrite", method=RequestMethod.POST)
	public String empWrite(EmployeeCommand employeeCommand) {
		if(!employeeCommand.isEmpPwEqualsEmpPwCon()) {
			return "thymeleaf/employee/empForm";
		}
		employeeWriteService.execute(employeeCommand);
		return "redirect:/";
	}
	
	@RequestMapping("empInfo")
	public String empInfo(@RequestParam(value="num") String empId, Model model) {
		employeeInfoService.execute(empId, model);
		return "thymeleaf/employee/empInfo";
	}
	
	@RequestMapping("empModify")
	public String empModify(@RequestParam(value="num") String empId, Model model) {
		employeeInfoService.execute(empId, model);
		return "thymeleaf/employee/empModify";
	}
	
	@RequestMapping(value="empUpdate", method=RequestMethod.POST)
	public String empUpdate(EmployeeCommand employeeCommand, Model model) {
		String path = employeeUpdateService.execute(employeeCommand, model);
		System.out.println(path);
		return path;
	}
	
	@RequestMapping("empDelete")
	public String empDelete(@RequestParam(value="num") String empId, Model model) {
		employeeInfoService.execute(empId, model);
		return "thymeleaf/employee/empDelPass";
	}
	
	@RequestMapping("empDeleteOk")
	public String empDeleteOk(EmployeeCommand employeeCommand, Model model) {
		String path = employeeDeleteService.execute(employeeCommand, model);
		return path;
	}
	
	@RequestMapping("empPassModify")
	public String empPassModify(@RequestParam(value="num") String empId, Model model) {
		employeeInfoService.execute(empId, model);
		return "thymeleaf/employee/empPass";
	}
	
	@RequestMapping("empPassUpdate")
	public String empPassUpdate(EmployeeCommand employeeCommand, Model model) {
		String path = employeePassUpdateService.execute(employeeCommand, model);
		return path;
	}
	
	@RequestMapping("empPassUpdateOk")
	public String empPassUpdateOk(EmployeeCommand employeeCommand) {
		employeePassChangService.execute(employeeCommand);
		return "redirect:empInfo?num="+employeeCommand.getEmpId();
	}
	
}
