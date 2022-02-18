package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class DeliveryDelService {

	@Autowired
	GoodsMapper goodsMapper;
	
	public Integer execute(String purchaseNum) {
		Integer i = goodsMapper.deliveryDel(purchaseNum);
		goodsMapper.purchaseStatusDel(purchaseNum);
		return i;
	}
}
