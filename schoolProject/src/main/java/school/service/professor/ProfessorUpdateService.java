package school.service.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import school.command.ProfessorCommand;
import school.domain.ProfessorDTO;
import school.mapper.ProfessorMapper;

@Service
public class ProfessorUpdateService {
	@Autowired
	ProfessorMapper professorMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	public String execute(ProfessorCommand professorCommand, BindingResult result, Model model) {
		ProfessorDTO dto = professorMapper.selectOne(professorCommand.getProfessorNum());
		
		if(passwordEncoder.matches(professorCommand.getProfessorPw(), dto.getProfessorPw())) {
			System.out.println("111 " +passwordEncoder.matches(professorCommand.getProfessorPw(), dto.getProfessorPw()));
			String proPw = passwordEncoder.encode(professorCommand.getNewPw());
			dto.setProfessorNum(professorCommand.getProfessorNum());
			dto.setProfessorName(professorCommand.getProfessorName());
			dto.setProfessorPhone(professorCommand.getProfessorPhone());
			dto.setProfessorEmail(professorCommand.getProfessorEmail());
			dto.setProfessorId(professorCommand.getProfessorId());
			dto.setProfessorPw(proPw);
			dto.setDepartmentNum(professorCommand.getDepartmentNum());
			professorMapper.setProfessorUpdate(dto);
			return "redirect:professorInfo/"+professorCommand.getProfessorNum();
		}else {
			result.rejectValue("professorPw", "professorCommand.getProfessorPw", "일치하지 않음");
			return "professor/proUpdate";
		}
	}
}
