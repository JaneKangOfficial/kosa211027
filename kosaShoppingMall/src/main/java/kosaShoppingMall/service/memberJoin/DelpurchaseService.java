package kosaShoppingMall.service.memberJoin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.DelGoodsPurchaseDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class DelpurchaseService {
	@Autowired
	MemberMapper memberMapper;
	
	public Integer execute(String [] purchaseNum) {
//		for(String i : purchaseNum) {
//			System.out.println("iiiii " +i);
//		}
//		for(String j : goodsName) {
//			System.out.println("jjjjj " +j);
//		}
		
//		DelGoodsPurchaseDTO dto = new DelGoodsPurchaseDTO();
//		dto.setPurchaseNum(purchaseNum);
//	
//		System.out.println("dtoooooo "+dto);
//		return memberMapper.delPurchase(dto);
		return memberMapper.delPurchase(purchaseNum);
		
	}
}
