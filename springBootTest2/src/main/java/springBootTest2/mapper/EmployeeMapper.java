package springBootTest2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.EmployeeDTO;

@Component
@Repository(value = "springBootTest2.mapper.EmployeeMapper")
public interface EmployeeMapper { // Mapper는 interface
	// mapper.xml의 id명과 같아야 한다.
	public Integer employeeInsert(EmployeeDTO dto);
	public List<EmployeeDTO> selectAll();
	public EmployeeDTO selectOne(String empNum);
	public Integer empDelete(String empNum);
	public Integer empUpdate(EmployeeDTO dto);
	
}
