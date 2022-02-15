package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.LoginMapper;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class MemberEmailCheckService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public Integer execute(String memberEmail, String memberId) {
		AuthInfo authInfo = loginMapper.checkEmail(memberEmail);
		MemberDTO dto = memberMapper.selectOneById(memberId);
		
		if(authInfo == null || (dto.getMemberEmail().trim().equals(memberEmail))) {
			return 0;
		}else {
			return 1;
		}
		
//		if(authInfo != null) {
//			return 1;
//		}else {
//			return 0;
//		}
	}
}
