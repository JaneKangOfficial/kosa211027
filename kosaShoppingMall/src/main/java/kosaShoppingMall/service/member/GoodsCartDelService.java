package kosaShoppingMall.service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.CartDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class GoodsCartDelService {
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(String goodsNum, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		CartDTO dto = new CartDTO();
		dto.setGoodsNum(goodsNum);
		dto.setMemberNum(memberMapper.selectOneById(authInfo.getUserId()).getMemberNum());
		
		memberMapper.cartDel(dto);
	}
}
