package springBootTest2.service.empLib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibUpdateService {
	@Autowired
	EmpLibMapper empLibMapper;
	
	public String execute(EmpLibCommand empLibCommand, HttpServletRequest request, Model model) {
		String path = "thymeleaf/empLib/empLibUpdate";
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		Integer empNum = empLibMapper.selectEmpNum(empId);
		
		Integer libNum = empLibCommand.getLibNum();
		EmpLibDTO dto = empLibMapper.selectOne(libNum); 
				
		if(dto.getLibPw().equals(empLibCommand.getLibPw()) && dto.getEmpNum().equals(empNum)) {
			dto.setEmpNum(empNum);
			dto.setLibNum(empLibCommand.getLibNum());
			dto.setLibWriter(empLibCommand.getLibWriter());
			dto.setLibSubject(empLibCommand.getLibSubject());
			dto.setLibContent(empLibCommand.getLibContent());
			dto.setLibPw(empLibCommand.getLibPw());
	
			empLibMapper.libUpdate(dto);
			path = "redirect:libInfo?num="+empLibCommand.getLibNum();
		}else {
			model.addAttribute("dto", dto);
			model.addAttribute("err_pw", "비밀번호가 일치하지 않거나 작성자가 아닙니다.");
		}
		return path;
	}
	
}
