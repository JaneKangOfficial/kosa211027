package kosaShoppingMall.command;

import lombok.Data;

@Data
public class EmpPwUpdateCommand {

	String empId;
	String empPw;
	String newPw;
}
