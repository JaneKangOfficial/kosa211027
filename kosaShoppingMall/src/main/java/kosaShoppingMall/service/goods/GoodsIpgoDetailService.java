package kosaShoppingMall.service.goods;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsIpgoDTO;
import kosaShoppingMall.domain.GoodsIpgoGoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsIpgoDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(String goodsNum, String ipgoDate, Model model) {
		// parameter 두개일 경우 dto에 담아서
		GoodsIpgoDTO idto = new GoodsIpgoDTO();
		idto.setGoodsNum(goodsNum);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			idto.setIpgoDate(sdf.parse(ipgoDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		GoodsIpgoGoodsDTO dto = goodsMapper.ipgoDetail(idto);
		model.addAttribute("goodsIpgoGoodsCommand", dto);
	}
}
