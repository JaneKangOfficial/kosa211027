package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("proSubDTO")
public class ProfessorSubjectDTO {
	
	String professorNum;
	String subjectNum;
	String[] subjectNums;
	String status;
	
	SubjectDTO subjectDTO;

}
