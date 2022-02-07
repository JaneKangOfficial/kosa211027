package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.GoodsDTO;

@Component
@Repository("kosaShoppingMall.mapper.GoodsMapper")
public interface GoodsMapper {
	public String autoNum();
	public Integer goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> selectAll();
	public GoodsDTO selectOne(String goodsNum);
	public Integer goodsUpdate(GoodsDTO dto);
	public Integer goodsDel(String goodsNum);
	public Integer visitCount(String goodsNum);
	public List<GoodsDTO> searchGoods(String goodsWord);

}
