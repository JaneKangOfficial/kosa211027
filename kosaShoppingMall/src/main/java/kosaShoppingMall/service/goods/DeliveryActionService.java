package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.DeliveryCommand;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class DeliveryActionService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(DeliveryCommand deliveryCommand) {
		String status = memberMapper.purchaseStatusSelect(deliveryCommand.getPurchaseNum());
		if(status.equals("결제완료")) {
			Integer i = goodsMapper.deliveryInsert(deliveryCommand);
			if(i >= 1) {
				// 상품대기중 ==> 배송완료
				goodsMapper.deliveryStatus(deliveryCommand.getPurchaseNum());
			}
		}
	}
}
