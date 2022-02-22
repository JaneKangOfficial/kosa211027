package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsInquireMapper;

@Service
public class GoodsInquireDetailService {
	@Autowired
	GoodsInquireMapper goodsInquireMapper;
	
	public void execute(String inquireNum, Model model) {
		GoodsInquireDTO dto = goodsInquireMapper.goodsInquire(inquireNum);
		model.addAttribute("goodsInquireDTO", dto);
	}
}
