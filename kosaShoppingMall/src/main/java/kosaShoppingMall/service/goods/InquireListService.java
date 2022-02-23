package kosaShoppingMall.service.goods;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsInquireMapper;

@Service
public class InquireListService {
	@Autowired
	GoodsInquireMapper goodsInquireMapper;
	
	public void execute(String goodsNum, Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memberId = authInfo.getUserId();
		session.setAttribute("memberId", memberId);
		
		List<GoodsInquireDTO> list = goodsInquireMapper.selectAll(goodsNum);
		model.addAttribute("list", list);
		
	}
	
}
