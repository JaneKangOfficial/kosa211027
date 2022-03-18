package school.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("proSubDTO")
public class ProfessorSubjectDTO {
	
	String professorNum;
	String subjectNum;
	String[] subjectNums;
	List<String[]> condition;
	String status;
	
	SubjectDTO subjectDTO;

}
