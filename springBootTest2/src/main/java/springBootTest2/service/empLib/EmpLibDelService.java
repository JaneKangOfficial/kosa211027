package springBootTest2.service.empLib;

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
public class EmpLibDelService {
	@Autowired
	EmpLibMapper empLibMapper;
	
	public String execute(EmpLibCommand empLibCommand, Model model, HttpSession session) {
		String path =  "redirect:libDelete?num="+empLibCommand.getLibNum();
		Integer libNum = empLibCommand.getLibNum();
		EmpLibDTO dto = empLibMapper.selectOne(libNum);
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		Integer empNum = empLibMapper.selectEmpNum(empId);

		if(dto.getLibPw().equals(empLibCommand.getLibPw()) && dto.getEmpNum().equals(empNum)) {
			System.out.println("oooooooooooooooooo");
			empLibMapper.libDel(libNum);
			path = "redirect:libList";
		}else {
			System.out.println("xxxxxxxxxxxxxxxxxx");
			//model.addAttribute("dto", dto);
			//model.addAttribute("err_pw", "비밀번호가 일치하지 않습니다.");
			session.setAttribute("err_pw", "비밀번호가 일치하지 않거나 작성자가 아닙니다.");
			path =  "redirect:libDelete?num="+empLibCommand.getLibNum();
		}
		return path;
	}
}
