package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.GoodsInquireCommand;
import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsInquireMapper;

@Service
public class InquireUpdateService {
	@Autowired
	GoodsInquireMapper goodsInquireMapper;
	
	public void execute(GoodsInquireCommand goodsInquireCommand) {
		GoodsInquireDTO dto = new GoodsInquireDTO();
		
		dto.setInquireNum(goodsInquireCommand.getInquireNum());
		dto.setInquireContent(goodsInquireCommand.getInquireContent());
		
		goodsInquireMapper.inquireUpdate(dto);
	}
}
