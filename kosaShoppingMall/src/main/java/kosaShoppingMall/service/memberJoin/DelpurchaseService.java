package kosaShoppingMall.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.DelGoodsPurchaseDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class DelpurchaseService {
	@Autowired
	MemberMapper memberMapper;
	
	public Integer execute(String[] purchaseNum) {
		
//		DelGoodsPurchaseDTO dto = new DelGoodsPurchaseDTO();
//		dto.setPurchaseNum(purchaseNum);
//		dto.setGoodsName(goodsName);
//		return memberMapper.delPurchase(dto);
		return memberMapper.delPurchase(purchaseNum);
	}
}
