package kosaShoppingMall.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.AuthInfo;

@Component
@Repository("kosaShoppingMall.mapper.LoginMapper")
public interface LoginMapper {
	public AuthInfo findId(String email);
}
