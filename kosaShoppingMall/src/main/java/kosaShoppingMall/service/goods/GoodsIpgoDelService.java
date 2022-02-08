package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsIpgoDelService {
	@Autowired
	GoodsMapper goodsMapper;

	public void execute( GoodsIpgoCommand goodsIpgoCommand) {
		goodsMapper.goodsIpgoDel(goodsIpgoCommand);
	}
}
