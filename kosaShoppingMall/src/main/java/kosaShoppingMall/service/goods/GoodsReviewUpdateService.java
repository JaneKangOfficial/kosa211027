package kosaShoppingMall.service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsReviewDTO;
import kosaShoppingMall.domain.ReviewDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class GoodsReviewUpdateService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(String purchaseNum, String goodsNum, HttpSession session, Model model) {
	
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memberNum = (memberMapper.selectOneById(authInfo.getUserId())).getMemberNum();
		
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setGoodsNum(goodsNum);
		reviewDTO.setMemberNum(memberNum);
		reviewDTO.setPurchaseNum(purchaseNum);
		
		GoodsReviewDTO dto = goodsMapper.reviewSelect(reviewDTO);
		model.addAttribute("goodsReviewDTO", dto);
	}
	
	// over riding
	public void execute(String purchaseNum, String goodsNum, String reviewContent) {
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setGoodsNum(goodsNum);
		reviewDTO.setPurchaseNum(purchaseNum);
		reviewDTO.setReviewContent(reviewContent);
		goodsMapper.reviewUpdate(reviewDTO);
	}

}
