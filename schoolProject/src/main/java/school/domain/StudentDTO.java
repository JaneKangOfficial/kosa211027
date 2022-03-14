package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("studentDTO")
public class StudentDTO {
	String studentNum;
	String studentId;
	String studentPw;
	String studentName;
	String studentPhone;
	String studentEmail;
	String departmentNum;
}
