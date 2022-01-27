package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeeCommand {
	@Size(min = 4, max = 12, message = "아이디는 4 ~ 12!!!")
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
	
	public boolean isEmpPwEqualsEmpPwCon() {
		return empPw.equals(empPwCon);
	}
	
}
