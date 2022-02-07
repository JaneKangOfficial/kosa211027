package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Component
@Service
public class GoodsInsertService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(GoodsCommand goodsCommand) {
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setDeliveryCost(goodsCommand.getDeliveryCost());
		dto.setVisitCount(goodsCommand.getVisitCount());
		
		goodsMapper.goodsInsert(dto);
		
	}
}
