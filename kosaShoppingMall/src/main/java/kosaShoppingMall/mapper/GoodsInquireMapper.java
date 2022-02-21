package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.GoodsInquireDTO;

@Component
@Repository("kosaShoppingMall.mapper.GoodsInquireMapper")
public interface GoodsInquireMapper {

	public List<GoodsInquireDTO> selectAll(String goodsNum);
	public Integer inquireInsert(GoodsInquireDTO dto);

}
