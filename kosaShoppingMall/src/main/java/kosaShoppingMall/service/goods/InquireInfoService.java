package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsInquireMapper;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class InquireInfoService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	GoodsInquireMapper goodsInquireMapper;

	public void execute(String goodsNum, Model model) {
		String goodsName = (goodsMapper.selectOne(goodsNum)).getGoodsName();
		model.addAttribute("goodsName", goodsName);
	}
	
	public void execute(Integer inquireNum, Model model) {
		GoodsInquireDTO dto = goodsInquireMapper.selectOne(inquireNum);
		model.addAttribute("dto", dto);
	}
}
