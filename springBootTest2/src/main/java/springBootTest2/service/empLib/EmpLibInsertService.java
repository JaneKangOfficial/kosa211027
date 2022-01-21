package springBootTest2.service.empLib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibInsertService {
	@Autowired
	EmpLibMapper empLibMapper;
	
	public void execute(EmpLibCommand empLibCommand, HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		Integer empNum = empLibMapper.selectEmpNum(empId);
		
		EmpLibDTO dto = new EmpLibDTO();
		dto.setEmpNum(empNum);
		dto.setLibWriter(empLibCommand.getLibWriter());
		dto.setLibSubject(empLibCommand.getLibSubject());
		dto.setLibContent(empLibCommand.getLibContent());
		dto.setLibPw(empLibCommand.getLibPw());
		dto.setIpAddr(request.getRemoteAddr());
		
		empLibMapper.empLibInsert(dto);
		
	}
}
