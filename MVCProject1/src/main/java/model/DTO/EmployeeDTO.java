package model.DTO;

import java.util.Date;

// DTO = VO
// 발음이 편한 것을 쓰면 된다.
public class EmployeeDTO {
	// 멤버필드
	// VO : Value Object
	Integer empNum;
	String empName;
	String empId;
	String empPw;
	Date empHireDate;
	String empEmail;
	Integer empSalary;
	String empPhone;
	
	// 메서드
	// DTO : Data Transfer Object
	public Integer getEmpNum() {
		return empNum;
	}
	public void setEmpNum(Integer empNum) {
		this.empNum = empNum;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpPw() {
		return empPw;
	}
	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	public Date getEmpHireDate() {
		return empHireDate;
	}
	public void setEmpHireDate(Date empHireDate) {
		this.empHireDate = empHireDate;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public Integer getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	
}
