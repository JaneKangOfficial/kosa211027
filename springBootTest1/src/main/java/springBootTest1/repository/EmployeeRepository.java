package springBootTest1.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest1.domain.EmployeeDTO;

@Component
// value는 xml namespace
@Repository(value="springBootTest1.repository.EmployeeMapper") // == mybatis(mapper)
public interface EmployeeRepository {
	public Integer employeeInsert(EmployeeDTO dto);
}
// xml 파일은 같은 위치에 같은 이름으로 만든다.