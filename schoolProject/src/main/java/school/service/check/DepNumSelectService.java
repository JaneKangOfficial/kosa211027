package school.service.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.mapper.StudentMapper;

@Service
public class DepNumSelectService {
	@Autowired
	StudentMapper studentMapper;

	public String execute(String departmentNum) {
		return studentMapper.autoNum(departmentNum);
	}
}
