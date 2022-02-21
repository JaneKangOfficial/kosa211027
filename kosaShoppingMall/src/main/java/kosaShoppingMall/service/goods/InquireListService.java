package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsInquireMapper;

@Service
public class InquireListService {
	@Autowired
	GoodsInquireMapper goodsInquireMapper;
	
	public void execute(String goodsNum, Model model) {
		List<GoodsInquireDTO> list = goodsInquireMapper.selectAll(goodsNum);
		System.out.println("listsss " + list);
		model.addAttribute("list", list);
		
	}
	
}
