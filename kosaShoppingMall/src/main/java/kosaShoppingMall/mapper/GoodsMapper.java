package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.GoodsIpgoDTO;
import kosaShoppingMall.domain.GoodsIpgoGoodsDTO;

@Component
@Repository("kosaShoppingMall.mapper.GoodsMapper")
public interface GoodsMapper {
	// goods
	public String autoNum();
	public Integer goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> selectAll();
	public GoodsDTO selectOne(String goodsNum);
	public Integer goodsUpdate(GoodsDTO dto);
	public Integer goodsDel(String goodsNum);
	public Integer visitCount(String goodsNum);
	public List<GoodsDTO> searchGoods(String goodsWord);
	
	// goodsIpgo
	public List<GoodsDTO> goodsItems(String goodsName);
	public Integer ipgoInsert(GoodsIpgoDTO dto);
	public List<GoodsIpgoDTO> ipgoSelect();
	// 1 대 1 정보 / GoodsIpgoGoodsDTO에서 GoodsDTO 하나에 GoodsIpgoDTO 하나
	// 1 대 1은 xml에서 resultMap
	public GoodsIpgoGoodsDTO ipgoDetail(GoodsIpgoDTO dto); 
	public GoodsDTO getGoodsIpgoInfo(GoodsIpgoDTO idto);
	public Integer goodsIpgoUpdate(GoodsIpgoDTO dto);
	public Integer goodsIpgoDel(GoodsIpgoCommand goodsIpgoCommand);

}
