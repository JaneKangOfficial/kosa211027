package kosaShoppingMall.service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(String goodsNum, Model model, HttpSession session) {
		goodsMapper.visitCount(goodsNum);
		GoodsDTO dto = goodsMapper.selectOne(goodsNum);
		model.addAttribute("goodsCommand", dto);
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memberNum = (memberMapper.selectOneById(authInfo.getUserId())).getMemberNum();
		
		/*
		 * GoodsDTO goodsDTO = new GoodsDTO(goodsNum); 
		 * String goodsNums = goodsDTO.getGoodsNum(); 
		 * MemberDTO memberDTO = new MemberDTO(); 
		 * memberDTO.setGoodsDTO(goodsNums);
		 */
		
	}
}
