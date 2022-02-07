package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Component
@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(String goodsNum, Model model) {
		goodsMapper.visitCount(goodsNum);
		GoodsDTO dto = goodsMapper.selectOne(goodsNum);
		System.out.println("dtoooooooo " + dto);
		model.addAttribute("goodsCommand", dto);
	}
}
