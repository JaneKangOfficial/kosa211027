package school.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import school.domain.AuthInfo;
import school.domain.StudentDTO;

@Repository("school.mapper.StudentMapper")
public interface StudentMapper {
	public String autoNum(String departmentNum);
	public Integer studentInsert(StudentDTO dto);
	public List<StudentDTO> selectAll();
	public StudentDTO selectOne(String studentNum);
	public Integer studentUpdate(StudentDTO dto);
	public Integer studentDel(String studentNum);
	public StudentDTO selectOneById(String studentId);
	
	public AuthInfo loginSelect(String userId);
}
