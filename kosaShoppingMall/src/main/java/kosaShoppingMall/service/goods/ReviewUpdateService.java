package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.ReviewDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class ReviewUpdateService {
	@Autowired
	GoodsMapper goodsMapper;

	public void execute(String reviewContent, String purchaseNum) {
		ReviewDTO dto = new ReviewDTO();
		dto.setPurchaseNum(reviewContent);
		dto.setReviewContent(reviewContent);
		goodsMapper.reviewListUpdate(dto);
	}
}
