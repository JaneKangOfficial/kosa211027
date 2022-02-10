package kosaShoppingMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.LoginMapper;

@Service
public class EmpIdCheckService {
	@Autowired
	LoginMapper loginMapper;
	
	public Integer execute(String empId) {
		
		System.out.println("aaa " + empId);
		AuthInfo authInfo = loginMapper.checkId(empId);
		System.out.println("111 " + authInfo);
		if(authInfo != null) {
			System.out.println("222 " + authInfo);
			return 1;
		}else {
			System.out.println("333 " + authInfo);
			return 0;
		}
	}
	
}
