package school.command;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProfessorCommand {
	@NotBlank(message = "번호를 입력해주세요")
	String professorNum;
	@NotBlank(message = "이름을 입력해주세요")
	String professorName;
	@NotBlank(message = "연락처를 입력해주세요")
	String professorPhone;
	@NotBlank(message = "이메일을 입력해주세요")
	String professorEmail;
	@NotBlank(message = "아이디를 입력해주세요")
	String professorId;
	@NotBlank(message = "비밀번호를 입력해주세요")
	String professorPw;
	@NotBlank(message = "비밀번호 확인을 입력해주세요")
	String professorPwCon;
	@NotBlank(message = "학과를 선택해주세요")
	String departmentNum;
	
	@NotBlank(message = "새로운 비밀번호를 입력해주세요")
	String newPw;
	
	public boolean passwordCon() {
		return professorPw.equals(professorPwCon);
	}

}
