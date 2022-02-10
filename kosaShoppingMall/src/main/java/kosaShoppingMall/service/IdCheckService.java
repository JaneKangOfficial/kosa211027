package kosaShoppingMall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class IdCheckService {
	@Autowired
	MemberMapper memberMapper;
	
	public Integer execute(String memberId) {
		AuthInfo authInfo = memberMapper.loginSelect(memberId);
		
		if(authInfo != null) {
			return 1;
		} else {
			return 0;
		}
	}
}
