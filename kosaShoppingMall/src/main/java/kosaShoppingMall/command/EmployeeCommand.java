package kosaShoppingMall.command;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeeCommand {
	@Size(min = 3, max = 12, message = "아이디는 3 ~ 12!!!")
	String empId;
	
	// NotEmpty : 공백 가능, 비어있지만 않으면 가능
	@NotEmpty(message = "비밀번호!!!")
	@Size(min = 3, max = 12)
	String empPw;

	// NotBlank : 공백 안됨
	@NotBlank(message = "비밀번호 확인!!!")
	@Size(min = 3, max = 12)
	String empPwCon;
	
	@NotEmpty(message = "이름!!!")
	String empName;
	
	@NotEmpty(message = "주소!!!")
	String empAddr;
	
	@NotEmpty(message = "연락처!!!")
	String empPhone;
	@Email(message = "이메일 형식!!!")
	@NotBlank(message="이메일!!!")
	String empEmail;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date[] schoolYear;
	String[] school;
	
	public boolean isEmpPwEqualsEmpPwCon() {
		return empPw.equals(empPwCon);
	}
	
}
