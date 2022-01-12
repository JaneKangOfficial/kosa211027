package springBootTest1.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeeCommand {
	Integer empNum;
	String empName;
	String empId;
	String empPw;
	String empPwCon;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 항상 Date 위에!
	Date empHireDate;
	String empEmail;
	Integer empSalary;
	String empPhone;
	
	public boolean isEmpPwEqualToEmpPwCon() {
		return empPw.equals(empPwCon);
	}
}
