package kosaShoppingMall.service.memberJoin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.OrderListDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class OrderProcessListService {
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO memberDTO = memberMapper.selectOneById(authInfo.getUserId());
		List<OrderListDTO> list = memberMapper.orderList(memberDTO.getMemberNum());
		model.addAttribute("list", list);
	}
}
