package school.service.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import school.command.ProfessorCommand;
import school.domain.ProfessorDTO;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorRegistService {
	@Autowired
	ProfessorMapper professorMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	public void execute(ProfessorCommand professorCommand) {
		String proPw = passwordEncoder.encode(professorCommand.getProfessorPw());
		
		ProfessorDTO dto = new ProfessorDTO();
		dto.setProfessorNum(professorCommand.getProfessorNum());
		dto.setProfessorName(professorCommand.getProfessorName());
		dto.setProfessorPhone(professorCommand.getProfessorPhone());
		dto.setProfessorEmail(professorCommand.getProfessorEmail());
		dto.setProfessorId(professorCommand.getProfessorId());
		dto.setProfessorPw(proPw);
		dto.setDepartmentNum(professorCommand.getDepartmentNum());
		
		professorMapper.setProfessorInsert(dto);
		
		
		
	}
}
