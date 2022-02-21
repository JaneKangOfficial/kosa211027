package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.ReviewDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class ReviewWriteService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	MemberMapper memberMapper;

	public void execute(String goodsNum, String reviewContent, String purchaseNum) {
		
		ReviewDTO dto = new ReviewDTO();
		dto.setGoodsNum(goodsNum);
		dto.setReviewContent(reviewContent);
		dto.setPurchaseNum(purchaseNum);
		goodsMapper.reviewWrite(dto);
	}
}
