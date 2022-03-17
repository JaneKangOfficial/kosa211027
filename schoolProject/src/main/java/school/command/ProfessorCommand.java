package school.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class ProfessorCommand {
	@NotBlank(message = "번호를 입력해주세요")
	String professorNum;
	@NotBlank(message = "이름을 입력해주세요")
	String professorName;
	@NotBlank(message = "연락처를 입력해주세요")
	String professorPhone;
	@Pattern(regexp="[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", 
			message = "이메일 형식에 맞지 않습니다.")
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
	
	String departmentName;
	
	public boolean passwordCon() {
		return professorPw.equals(professorPwCon);
	}

}
