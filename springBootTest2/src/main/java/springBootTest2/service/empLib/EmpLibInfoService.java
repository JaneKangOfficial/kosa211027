package springBootTest2.service.empLib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibInfoService {
	@Autowired
	EmpLibMapper empLibMapper;
	
	public void execute(Integer libNum, Model model) {
		EmpLibDTO dto = empLibMapper.selectOne(libNum);
		model.addAttribute("dto", dto);
	}
}
