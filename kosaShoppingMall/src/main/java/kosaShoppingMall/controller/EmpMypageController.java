package kosaShoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kosaShoppingMall.command.EmpPwUpdateCommand;
import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.service.empMypage.EmpDetailService;
import kosaShoppingMall.service.empMypage.EmpPwUpdateService;
import kosaShoppingMall.service.empMypage.EmpUpdateService;
import kosaShoppingMall.service.employees.EmpEmailCheckService;

@Controller
@RequestMapping("empMypage")
public class EmpMypageController {
	@Autowired
	EmpDetailService empDetailService;
	@Autowired
	EmpUpdateService empUpdateService;
	@Autowired
	EmpPwUpdateService empPwUpdateService;
	@Autowired
	EmpEmailCheckService empEmailCheckService;
	
	@ModelAttribute
	EmpPwUpdateCommand setEmpPwUpdateCommand() {
		 return new EmpPwUpdateCommand();
	}
	
	
	@RequestMapping(value="empDetail")
	public String empDetail(HttpSession session, Model model) {
		empDetailService.execute(session, model);
		return "thymeleaf/employeesShip/empDetail";
	}
	
	@RequestMapping(value="empUpdate", method = RequestMethod.GET )
	public String empUpdate(HttpSession session, Model model, EmployeeCommand employeeCommand) {
		empDetailService.execute(session, model);
		return "thymeleaf/employeesShip/empUpdate";
	}
	
	@RequestMapping(value="empUpdate", method = RequestMethod.POST )
	public String empUpdateOk(@Validated EmployeeCommand employeeCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/employeesShip/empUpdate";
		}
		
		Integer i = empEmailCheckService.execute(employeeCommand.getEmpEmail());
		if(i == 1) {
			result.rejectValue("empEmail", "employeeCommand.empEmail", "중복 이메일입니다.");
			return "thymeleaf/employeesShip/empUpdate";
		}
		
		String path = empUpdateService.execute(employeeCommand, result);
		return path;
	}
	
	@RequestMapping(value="empPwUpdate", method=RequestMethod.GET) 
	public String empPwUpdate(HttpSession session, Model model  ) {
		empDetailService.execute(session, model);
		return "thymeleaf/employeesShip/empPwUpdate";
	}
	
	@RequestMapping(value="empPwUpdate", method=RequestMethod.POST)
	public String empPwUpdateOk (EmpPwUpdateCommand empPwUpdateCommand, BindingResult result) {
		
		String path = empPwUpdateService.execute(empPwUpdateCommand, result);
		return path;
	}
}
