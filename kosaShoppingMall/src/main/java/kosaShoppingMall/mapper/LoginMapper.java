package kosaShoppingMall.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.command.FindIdCommand;
import kosaShoppingMall.command.FindPasswordCommand;
import kosaShoppingMall.domain.AuthInfo;

@Component
@Repository("kosaShoppingMall.mapper.LoginMapper")
public interface LoginMapper {
	// id 찾기
	public AuthInfo findId(String email);
	// 메일로 아이디 찾기
	public String findIdByEmail(FindIdCommand findIdCommand);

	// 등록 아이디 중복체크
	public AuthInfo checkId(String userId);
	// 등록 이메일 중복체크
	public AuthInfo checkEmail(String email);
	// 메일로 비밀번호 찾기
	public String findPw(FindPasswordCommand findPasswordCommand);
	
}
