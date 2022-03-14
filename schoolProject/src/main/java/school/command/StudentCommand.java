package school.command;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class StudentCommand {

	@NotBlank(message = "학번을 입력해주세요")
	String studentNum;
	@NotBlank(message = "아이디를 입력해주세요")
	String studentId;
	@NotBlank(message = "비밀번호를 입력해주세요")
	String studentPw;
	@NotBlank(message = "비밀번호 확인을 입력해주세요")
	String studentPwCon;
	@NotBlank(message = "이름을 입력해주세요")
	String studentName;
	@NotBlank(message = "연락처를 입력해주세요")
	String studentPhone;
	@NotBlank(message = "이메일을 입력해주세요")
	String studentEmail;
	@NotBlank(message = "학과를 선택해주세요")
	String departmentNum;
	
	@NotBlank(message = "새로운 비밀번호를 입력해주세요")
	String newPw;
	@NotBlank(message = "새로운 비밀번호 확인을 입력해주세요")
	String newPwCon;
	
	public boolean pwCon() {
		return studentPw.equals(studentPwCon);
	}
	
	public boolean newPwCon() {
		return newPw.equals(newPwCon);
	}
	
}
