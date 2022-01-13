package springBootTest2.controller.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.EmployeeCommand;
import springBootTest2.service.employees.EmployeeDeleteService;
import springBootTest2.service.employees.EmployeeInfoService;
import springBootTest2.service.employees.EmployeeListService;
import springBootTest2.service.employees.EmployeeUpdateService;
import springBootTest2.service.employees.EmployeeWriteService;

// @Controller를 적어주지 않으면 extends HttpServlet을 받아 jsp가 된다. 
// @Controller가 있어야 스프링부트 
@Controller
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	EmployeeWriteService employeeWriteService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeInfoService employeeInfoService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	@Autowired
	EmployeeUpdateService employeeUpdateService;
	
	/*
	 	절대경로 : /대한민국/경기도/코사시/코사동/코사아파트/101호
	 	상대경로 : 현재 위치가 대한민국일 경우 : 경기도/코사시/코사동/코사아파트/101호
	 			현재 위치가 코사시일 경우 : 코사동/코사아파트/101호
	 	
	 					상대경로					내위치/상대경로
		@RequestMapping("emp/employeesList") => emp/emp/employeesList => 404
		
	 	ContextPath 다음부터의 주소를 적는다.
		/emp/employeesList	=> emp/employeesList
		employeesList	=> emp/employeesList
	 */
		
	@RequestMapping("employeesList")
	// Controller의 return 은 무조건 주소이기 때문에 반환값은 String
	public String empList(Model model) { 
		employeeListService.execute(model);
		return "thymeleaf/employees/empList";
	}
	
	@RequestMapping("employeeRegist")
	public String empForm() {
		return "thymeleaf/employees/empForm";
	}
	
	@RequestMapping("employeeWrite")
	public String empWrite(EmployeeCommand employeeCommand) {
		employeeWriteService.execute(employeeCommand);
		return "redirect:employeesList";
	}
	
	@RequestMapping("employeeInfo")
	public String empInfo(@RequestParam(value="num") String empNum, Model model) {
		// public String empInfo(@RequestParam(value="num") String empNum) {
		// String empNum = request.getParameter("num");
		// 같은 의미이다.
		employeeInfoService.execute(empNum, model);
		return "thymeleaf/employees/empDetail";
	}
	
	@RequestMapping("employeeDelete")
	public String empDelete(@RequestParam(value="num") String empNum) {
		employeeDeleteService.execute(empNum);
		return "redirect:employeesList";
	}
	
	@RequestMapping("employeeModify")
	public String empUpdate(@RequestParam(value="num") String empNum, Model model) {
		employeeInfoService.execute(empNum, model);
		return "thymeleaf/employees/empUpdate";
	}
	
	@RequestMapping("employeeUpdate")
	public String empUpdateOk(EmployeeCommand employeeCommand) {
		employeeUpdateService.execute(employeeCommand);
		return "redirect:employeeInfo?num="+employeeCommand.getEmpNum();
	}
	
}
