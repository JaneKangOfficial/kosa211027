package kosaShoppingMall.service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.GoodsInquireCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.mapper.GoodsInquireMapper;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class InquireWriteService {
	@Autowired
	GoodsInquireMapper goodsInquireMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(GoodsInquireCommand goodsInquireCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memberNum = (memberMapper.selectOneById(authInfo.getUserId())).getMemberNum();
		
		GoodsInquireDTO dto = new GoodsInquireDTO();
		dto.setInquireKind(goodsInquireCommand.getHchkQueryType());
		dto.setInquireSubject(goodsInquireCommand.getInquireSubject());
		dto.setInquireContent(goodsInquireCommand.getInquireContent());
		dto.setGoodsNum(goodsInquireCommand.getGoodsNum());
		dto.setMemberNum(memberNum);
		
		System.out.println("dto!!!!!!!! " + dto);
		goodsInquireMapper.inquireInsert(dto);
	}
	
}
