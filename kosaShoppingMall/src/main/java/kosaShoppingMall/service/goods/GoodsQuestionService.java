package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsInquireMapper;

@Service
public class GoodsQuestionService {
	@Autowired
	GoodsInquireMapper goodsInquireMapper;
	
	public void execute(Model model) {
		List<GoodsInquireDTO> list = goodsInquireMapper.goodsInquire();
		model.addAttribute("list", list);
	}
}
