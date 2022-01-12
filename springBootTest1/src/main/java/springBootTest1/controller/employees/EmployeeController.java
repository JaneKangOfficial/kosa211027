package springBootTest1.controller.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootTest1.command.EmployeeCommand;
import springBootTest1.service.employees.EmployeeWriteService;

@Controller
// "/" 있으면 절대경로, 없으면 상대경로
@RequestMapping("emp") // 앞 주소 고정
public class EmployeeController {
	@Autowired
	EmployeeWriteService employeeWriteService;
	
	@RequestMapping("employeesList")
	public String empList() {
		return "thymeleaf/employees/empList";
	}
	
	@RequestMapping("employeesForm")
	public String empForm() {
		return "thymeleaf/employees/empForm";
	}
	
	@RequestMapping("employeeWrite")
	// Model == HttpServletRequest (html에 값 전달)
	// 스프링에서는 request 대신에 Model을 사용
	public String empWrite(EmployeeCommand employeeCommand, Model model) {
		// Service는 jsp의 Controller
		String path = employeeWriteService.execute(employeeCommand, model);
		return path;
	}
}
