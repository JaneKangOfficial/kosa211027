package school.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import school.domain.DepartmentDTO;
import school.domain.ProfessorDTO;
import school.domain.SubjectDTO;

@Repository("school.mapper.DepartmentMapper")
public interface DepartmentMapper {
	
	public String autoNum();
	public Integer departmentInsert(DepartmentDTO dto);
	public List<DepartmentDTO> selectAll();
	public DepartmentDTO selectOne(String departmentNum);
	public Integer departmentUpdate(DepartmentDTO dto);
	public Integer departmentDel(String departmentNum);
	
	public List<DepartmentDTO> selectNumAll();
	public List<SubjectDTO> selectSubject(String departmentNum);
	public List<ProfessorDTO> selectProfessor(String subjectNum);

}
