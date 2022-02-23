package kosaShoppingMall.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.EducationDTO;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.domain.StartEndPageDTO;

@Component
@Repository(value="kosaShoppingMall.mapper.EmployeeMapper")
public interface EmployeeMapper {
	public Integer empInsert(EmployeeDTO dto);
	public List<EmployeeDTO> selectAll(StartEndPageDTO dto);
	public EmployeeDTO selectOne(String empId);
	public Integer empUpdate(EmployeeDTO dto);
	public Integer empDel(String empId);
	public Integer empPassUpdate(EmployeeDTO dto);
	// 여러개 삭제
	// 1. 배열 이용
	public Integer empDels(String[] deletes);
	// 2. 리스트 이용
	public Integer empDels2(List<String> cs);
	// 3. Map을 이용
	public Integer empDels3(Map<String, Object> condition);
	
	// 전체 count
	public int empCount();
	
	// 메일로 비밀번호 찾기
	public Integer changPw(AuthInfo authInfo);
	
	//
	public Integer educationInsert(List<EducationDTO> lists);
}
