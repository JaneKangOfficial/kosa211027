package school.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import school.domain.ProfessorSubjectDTO;

@Repository("school.mapper.professorSubjectMapper")
public interface ProfessorSubjectMapper {
	
	public Integer subInsert(ProfessorSubjectDTO dto);
	public Integer subInsertOne(ProfessorSubjectDTO dto);
	public List<ProfessorSubjectDTO> selectAll();
	public Integer subDel(String subjectNum);
	public ProfessorSubjectDTO selectOne(ProfessorSubjectDTO dto);
	public Integer subDel2(ProfessorSubjectDTO dto);
	public Integer subDeletes(List<String[]> condition);
	public Integer subIn(List<String[]> condition);
	public List<ProfessorSubjectDTO> selectProId(String professorNum);

}
