package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsInquireMapper;

@Service
public class InquireDelService {
	@Autowired
	GoodsInquireMapper goodsInquireMapper;
	
	public void execute(Integer inquireNum, String goodsNum) {
		GoodsInquireDTO dto = new GoodsInquireDTO();
		dto.setInquireNum(inquireNum);
		dto.setGoodsNum(goodsNum);
		
		Integer i = goodsInquireMapper.inquireDel(dto);
		System.out.println(i+"개 행이(가) 삭제되었습니다.");
	}
}
