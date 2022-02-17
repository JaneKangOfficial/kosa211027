package kosaShoppingMall.service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsBuy;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class GoodsCartDelsService {
	@Autowired
	MemberMapper memberMapper;
	
	public Integer execute(String[] goodsNum, HttpSession session) {
		 AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo"); String
		 memberNum = (memberMapper.selectOneById(authInfo.getUserId()).getMemberNum());
		 
		 GoodsBuy dto = new GoodsBuy(); 
		 dto.setGoodsNums(goodsNum);
		 dto.setMemberNum(memberNum);
		
		Integer i = memberMapper.cartDels(dto);
//		Integer i = memberMapper.cartDels(goodsNum);
		return i;
	}
}
