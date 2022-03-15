package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("professorDTO")
public class ProfessorDTO {
	String professorNum;
	String professorName;
	String professorPhone;
	String professorEmail;
	String professorId;
	String professorPw;
	String departmentNum;

	String departmentName;
	
	String newPw;
	String professorPwCon;
}
