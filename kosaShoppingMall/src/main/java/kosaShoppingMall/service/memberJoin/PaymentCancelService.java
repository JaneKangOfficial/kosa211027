package kosaShoppingMall.service.memberJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.MemberMapper;

@Service
public class PaymentCancelService {
	@Autowired
	MemberMapper memberMapper;

	public void execute(String purchaseNum) {
		memberMapper.paymentCancel(purchaseNum);
		memberMapper.purchaseCancelStatus(purchaseNum);
	}
}
