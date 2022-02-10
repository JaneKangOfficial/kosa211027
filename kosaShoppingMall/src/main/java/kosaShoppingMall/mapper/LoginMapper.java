package kosaShoppingMall.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.AuthInfo;

@Component
@Repository("kosaShoppingMall.mapper.LoginMapper")
public interface LoginMapper {
	public AuthInfo findId(String email);

	// 등록 아이디 중복체크
	public AuthInfo checkId(String userId);
	// 등록 이메일 중복체크
	public AuthInfo checkEmail(String email);
	
}
