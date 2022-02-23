package kosaShoppingMall.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.EducationDTO;
import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.domain.StartEndPageDTO;

@Repository
public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	
	// class 사용시 mapper에 있는 namespace를 꼭 적어줘야 한다.
	String namespace = "kosaShoppingMall.mapper.EmployeeMapper";
	String statement;

	public Integer empInsert(EmployeeDTO dto) {
		statement = namespace + ".empInsert";
		//return sqlSession.insert("kosaShoppingMall.mapper.EmployeeMapper.empInsert", dto);
		return sqlSession.insert(statement, dto);
	}
	public List<EmployeeDTO> selectAll(StartEndPageDTO dto) {
		statement = namespace + ".selectAll";
		return sqlSession.selectList(statement, dto); // selectList : 여러개 반환 (mybatis에서 selectList 사용)
	}
	public EmployeeDTO selectOne(String empId) {
		statement = namespace + ".selectOne";
		return sqlSession.selectOne(statement, empId); // selectOne : 하나만 반환
	}
	public Integer empUpdate(EmployeeDTO dto) {
		statement = namespace + ".empUpdate";
		return sqlSession.update(statement, dto);
	}
	public Integer empDel(String empId) {
		statement = namespace + ".empDel";
		return sqlSession.update(statement, empId); // update : insert/delete/update 전부 update 사용 가능 (delete로 적어도 상관없음!)
	}
	public Integer empPassUpdate(EmployeeDTO dto) {
		statement = namespace + ".empPassUpdate"; // class 사용시 mapper id 달라도 된다. 하지만 일반적으로 같게 만든다.
		return sqlSession.update(statement, dto); 
	}
	
	// 여러개 삭제
	// 1. 배열 이용
	public Integer empDels(String[] deletes) {
		statement = namespace + ".empDels";
		return sqlSession.update(statement, deletes);
	}
	// 2. 리스트 이용
	public Integer empDels2(List<String> cs) {
		statement = namespace + ".empDels2";
		return sqlSession.update(statement, cs);
	}
	// 3. Map을 이용
	public Integer empDels3(Map<String, Object> condition) {
		statement = namespace + ".empDels3";
		return sqlSession.update(statement, condition);
	}
	
	// 전체 count
	public int empCount() {
		statement = namespace + ".empCount";
		return sqlSession.selectOne(statement);
	}
	
	// 메일로 비밀번호 찾기
	public Integer changPw(AuthInfo authInfo) {
		statement = namespace + ".changPw";
		return sqlSession.update(statement, authInfo);
	}

}
