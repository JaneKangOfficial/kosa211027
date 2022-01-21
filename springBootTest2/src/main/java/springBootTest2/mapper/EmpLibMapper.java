package springBootTest2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.EmpLibDTO;

@Component
@Repository("springBootTest2.mapper.EmpLibMapper")
public interface EmpLibMapper {
	public Integer empLibInsert(EmpLibDTO dto);
	public Integer selectEmpNum(String empId);
	public List<EmpLibDTO> selectAll();
	public EmpLibDTO selectOne(Integer libNum);
	public Integer libUpdate(EmpLibDTO dto);
	public Integer libDel(Integer libNum);
}
