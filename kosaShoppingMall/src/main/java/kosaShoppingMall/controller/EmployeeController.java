package kosaShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.EmployeeCommand;
import kosaShoppingMall.service.employees.EmpDelsService;
import kosaShoppingMall.service.employees.EmpEmailCheckService;
import kosaShoppingMall.service.employees.EmpIdCheckService;
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
	@Autowired
	EmpDelsService empDelsService;
	@Autowired
	EmpIdCheckService empIdCheckService;
	@Autowired
	EmpEmailCheckService empEmailCheckService;

	
	@ModelAttribute
	// command가 필요한 곳(html에서 th:object)에 전부 command를 전송하겠습니다.
	// 같은 내용 = model.addAttribute("employeeCommmand", new EmployeeCommand());
	EmployeeCommand setEmployeeCommand() {
		return new EmployeeCommand();
	}
	
	@RequestMapping("empList")
	public String empList(@RequestParam(value="page", defaultValue = "1", required = false)Integer page, Model model) {
		employeeListService.execute(model,page);
		return "thymeleaf/employee/empList";
	}
	
	@RequestMapping("empJoin")
	public String empJoin() {
		// 위에 @ModelAttribute 내용과 같다.
		// model.addAttribute("employeeCommmand", new EmployeeCommand());
		return "thymeleaf/employee/empForm";
	}
	
	@RequestMapping(value="empWrite", method=RequestMethod.GET)
	public String empWrite1() {
		return "thymeleaf/employee/empForm";
	}
	
	// BindingResult가 Validated을 사용하기 위해서는 무조건 Command 바로 뒤에 있어야 한다.
	// validated에 error가 있으면 result가 command에 담아서 error 메세지를 출력한다. 따라서 메시지 출력을 위해서는 command가 있어야 한다.
	@RequestMapping(value="empWrite", method=RequestMethod.POST)
	public String empWrite(@Validated EmployeeCommand employeeCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/employee/empForm";
		}
		
		if(!employeeCommand.isEmpPwEqualsEmpPwCon()) {
			result.rejectValue("empPwCon", "employeeCommand.empPwCon", "비밀번호 확인이 다릅니다.");
			return "thymeleaf/employee/empForm";
		}
		
		Integer i = empIdCheckService.execute(employeeCommand.getEmpId());
		if(i == 1) {
			result.rejectValue("empId", "employeeCommand.empId", "중복 아이디입니다.");
			return "thymeleaf/employee/empForm";
		}
		
		i = empEmailCheckService.execute(employeeCommand.getEmpEmail());
		if(i == 1) {
			result.rejectValue("empEmail", "employeeCommand.empEmail", "중복 이메일입니다.");
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
	
	// command가 아닌 db(dto)에서 값을 받아오는 경우는 model을 사용한다.
	@RequestMapping("empModify")
	public String empModify(@RequestParam(value="num") String empId, Model model) {
		employeeInfoService.execute(empId, model);
		return "thymeleaf/employee/empModify";
	}
	
	// Command 값은 model이 받지 않아도 html로 전달할 수 있다.
	// BindingResult : 항상 Command 뒤에 있어야 한다. error를 확인하고 메세지를 html페이지로 전달할 수 있는 객체. redirect 안된다.
	@RequestMapping(value="empUpdate", method=RequestMethod.POST)
	public String empUpdate(EmployeeCommand employeeCommand, BindingResult result) {
		String path = employeeUpdateService.execute(employeeCommand, result);
		System.out.println(path);
		
		Integer i = empEmailCheckService.execute(employeeCommand.getEmpEmail());
		if(i == 1) {
			result.rejectValue("empEmail", "employeeCommand.empEmail", "중복 이메일입니다.");
			return "thymeleaf/employee/empModify";
		}
		
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
	public String empPassUpdate(EmployeeCommand employeeCommand, BindingResult result) {
		String path = employeePassUpdateService.execute(employeeCommand, result);
		return path;
	}
	
	@RequestMapping("empPassUpdateOk")
	public String empPassUpdateOk(EmployeeCommand employeeCommand) {
		employeePassChangService.execute(employeeCommand);
		return "redirect:empInfo?num="+employeeCommand.getEmpId();
	}
	
	// 여러개 삭제
	@RequestMapping(value="empDels", method=RequestMethod.POST)
	public String empDels(@RequestParam(value="delete") String[] deletes) {
		empDelsService.execute(deletes);
		return "redirect:empList";
	}
	

	
}
