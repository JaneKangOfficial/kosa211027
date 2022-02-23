package kosaShoppingMall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.command.FindIdCommand;
import kosaShoppingMall.command.FindPasswordCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapperImpl;

@Repository
public class LoginRepository implements LoginMapperImpl{ // interface 와 class 같이 사용 (주로 회사에서 사용)
	@Autowired
	SqlSession sqlSession;
	String namespace="kosaShoppingMall.mapper.LoginMapper";
	String statement;
	
	@Override
	public AuthInfo findId(String email) {
		statement = namespace + ".findId";
		return sqlSession.selectOne(email);
	}
	@Override
	public String findIdByEmail(FindIdCommand findIdCommand) {
		statement = namespace + ".findIdByEmail";
		return sqlSession.selectOne(statement,findIdCommand);
	}
	@Override
	public AuthInfo checkId(String userId) {
		statement = namespace + ".checkId";
		return sqlSession.selectOne(statement,userId);
	}
	@Override
	public AuthInfo checkEmail(String email) {
		statement = namespace + ".checkEmail";
		return sqlSession.selectOne(statement,email);
	}
	@Override
	public String findPw(FindPasswordCommand findPasswordCommand) {
		statement = namespace + ".findPw";
		return sqlSession.selectOne(statement,findPasswordCommand);
	}
		
}
