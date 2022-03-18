package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("coursesSubjectDTO")
public class CoursesSubjectDTO {
	
	String professorNum;
	String subjectNum;
	String studentNum;
}
