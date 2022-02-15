package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsListPageService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(Model model) {
		
		List<GoodsDTO> list = goodsMapper.selectAll(new StartEndPageDTO());
		model.addAttribute("lists", list);
		
	}
}
