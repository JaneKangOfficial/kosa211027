package kosaShoppingMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;

@Service
public class EmpEmailCheckService {
	@Autowired
	LoginMapper loginMapper;
	
	public Integer execute(String empEmail) {
		AuthInfo authInfo = loginMapper.checkEmail(empEmail);
		
		if(authInfo != null) {
			return 1;
		}else {
			return 0;
		}
		
	}
}
