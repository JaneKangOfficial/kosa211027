package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.MemberMapper;

@Service
public class GoodsCartDelsService {
	@Autowired
	MemberMapper memberMapper;
	
	public Integer execute(String[] goodsNum) {
		Integer i = memberMapper.cartDels(goodsNum);
		return i;
	}
}
