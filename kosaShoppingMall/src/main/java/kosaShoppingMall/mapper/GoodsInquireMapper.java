package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.GoodsInquireDTO;
import kosaShoppingMall.domain.ReviewDTO;

@Component
@Repository("kosaShoppingMall.mapper.GoodsInquireMapper")
public interface GoodsInquireMapper {

	public List<GoodsInquireDTO> selectAll(String goodsNum);
	public Integer inquireInsert(GoodsInquireDTO dto);
	// 관리자 상품문의
	public List<GoodsInquireDTO> goodsInquire();
	// 관리자 상품문의 상세보기
	public GoodsInquireDTO goodsInquire(String inquireNum);
	// 관리자 상품문의 답변
	public Integer setInquireAnswer(GoodsInquireDTO goodsInquireDTO);
	
	public GoodsInquireDTO selectOne(Integer inquireNum);
	public Integer inquireUpdate(GoodsInquireDTO dto);
	public Integer inquireDel(GoodsInquireDTO dto);

}
