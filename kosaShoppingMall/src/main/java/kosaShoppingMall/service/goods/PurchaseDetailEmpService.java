package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.OrderListDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class PurchaseDetailEmpService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	GoodsMapper goodsMapper;
	
	public void execute(String purchaseNum, Model model) {
		List<OrderListDTO> list = goodsMapper.purchaseDetail(purchaseNum);
		
		String purchaseStatus = memberMapper.purchaseStatusSelect(purchaseNum);
		
		OrderListDTO dto = new OrderListDTO();
		dto.setPurchaseNum(purchaseNum);
		dto.setPurchaseStatus(purchaseStatus);
		
		if(dto.getPurchaseStatus().equals("결제완료")) {
			memberMapper.purchaseStatusReady(dto);
		}
		model.addAttribute("list", list);
	}
}
