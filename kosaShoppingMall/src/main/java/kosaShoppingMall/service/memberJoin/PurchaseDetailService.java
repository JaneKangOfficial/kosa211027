package kosaShoppingMall.service.memberJoin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.OrderListDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class PurchaseDetailService {
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(String purchaseNum, Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		List<OrderListDTO> list = memberMapper.purchaseDetail(purchaseNum);
		
		String purchaseStatus = memberMapper.purchaseStatusSelect(purchaseNum);
		
		OrderListDTO dto = new OrderListDTO();
		dto.setPurchaseNum(purchaseNum);
		dto.setPurchaseStatus(purchaseStatus);
		
		if(dto.getPurchaseStatus().equals("결제완료") && (authInfo.getGrade().equals("emp") )) {
			memberMapper.purchaseStatusReady(dto);
		}
		model.addAttribute("list", list);
	}
}
