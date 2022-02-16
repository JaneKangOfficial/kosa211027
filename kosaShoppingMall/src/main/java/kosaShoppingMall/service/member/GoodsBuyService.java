package kosaShoppingMall.service.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsBuy;
import kosaShoppingMall.domain.GoodsCartDTO;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class GoodsBuyService {
	@Autowired
	MemberMapper memberMapper;

	public void execute(String[] goodsNums, HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		MemberDTO memberDTO = memberMapper.selectOneById(authInfo.getUserId());
		
		GoodsBuy goodsBuy = new GoodsBuy();
		goodsBuy.setGoodsNums(goodsNums);
		goodsBuy.setMemberNum(memberDTO.getMemberNum());
		
		List<GoodsCartDTO> list = memberMapper.goodsOrder(goodsBuy);
		
		Long goodsTotalPrice = 0L;
		for(GoodsCartDTO dto : list) {
			goodsTotalPrice += dto.getCartDTO().getTotalPrice();
		}
		Long goodsTotalDelivery = 0L;
		for(GoodsCartDTO dto : list) {
			goodsTotalPrice += dto.getGoodsDTO().getDeliveryCost();
		}
		
		model.addAttribute("goodsTotalDelivery", goodsTotalDelivery);
		model.addAttribute("goodsTotalPrice", goodsTotalPrice);
		model.addAttribute("list",list);
		
	}
}
