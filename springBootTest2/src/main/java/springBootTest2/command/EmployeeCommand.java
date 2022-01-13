package springBootTest2.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/*
 	Command는 request 대신 사용 
	request가 받아온 값을 command가 사용 
	html -> tomcat -> request -> command
	html name(parameter)과 command에서 사용하는 member field는 같아야 한다.
 */

@Data
public class EmployeeCommand {
	Integer empNum;
	String empName;
	String empId;
	String empPw;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // command에는 꼭 적어줘야 한다. / dto에는 선택
	Date empHireDate;
	String empEmail;
	Integer empSalary;
	String empPhone;
}
