package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;

@Service
public class MemberEmailCheckService {
	@Autowired
	LoginMapper loginMapper;
	
	public Integer execute(String memberEmail) {
		System.out.println("111 " + memberEmail);
		AuthInfo authInfo = loginMapper.checkEmail(memberEmail);
		System.out.println("222 " + authInfo);
		
		if(authInfo != null) {
			return 1;
		}else {
			return 0;
		}
	}
}
