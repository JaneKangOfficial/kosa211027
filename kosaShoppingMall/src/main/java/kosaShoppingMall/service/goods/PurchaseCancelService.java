package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class PurchaseCancelService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(String purchaseNum) {
		goodsMapper.purchaseCancel(purchaseNum);
		memberMapper.purchaseCancelStatus(purchaseNum);
	}
}
