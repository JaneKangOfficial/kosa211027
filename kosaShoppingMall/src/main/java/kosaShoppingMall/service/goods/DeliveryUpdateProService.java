package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.DeliveryCommand;
import kosaShoppingMall.domain.OrderListDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class DeliveryUpdateProService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public Integer execute(DeliveryCommand deliveryCommand) {
		OrderListDTO dto = new OrderListDTO();
		dto.setPurchaseNum(deliveryCommand.getPurchaseNum());
		dto.setDeliveryCompany(deliveryCommand.getDeliveryCompany());
		dto.setDeliveryNumber(deliveryCommand.getDeliveryNumber());
		
		return goodsMapper.deliveryUpdate(dto);
	}
}
