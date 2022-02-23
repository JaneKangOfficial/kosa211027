package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.ReviewDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class ReviewDelService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(String purchaseNum, String goodsNum) {
		ReviewDTO dto = new ReviewDTO();
		dto.setGoodsNum(goodsNum);
		dto.setPurchaseNum(purchaseNum);
		goodsMapper.reviewDel(dto);
	}
	
}
