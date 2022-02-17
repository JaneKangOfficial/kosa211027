package kosaShoppingMall.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.MemberMapper;

@Service
public class PaymentDelService {
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(String purchaseNum) {
		memberMapper.paymentDel(purchaseNum);
	}
}
