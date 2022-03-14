package school.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import school.domain.ProfessorDTO;

@Repository("school.mapper.ProfessorMapper")
public interface ProfessorMapper {
	
	public String autoNum();
	public Integer setProfessorInsert(ProfessorDTO dto);
	public List<ProfessorDTO> selectAll();
	public ProfessorDTO selectOne(String professorNum);
	public Integer setProfessorUpdate(ProfessorDTO dto);
	public Integer proDel(String professorNum);
	public ProfessorDTO selectOneById(String professorId);
	
}
