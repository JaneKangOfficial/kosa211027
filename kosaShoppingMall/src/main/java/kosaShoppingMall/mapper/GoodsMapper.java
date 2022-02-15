package kosaShoppingMall.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.domain.CartDTO;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.GoodsIpgoDTO;
import kosaShoppingMall.domain.GoodsIpgoGoodsDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.domain.WishDTO;

@Component
@Repository("kosaShoppingMall.mapper.GoodsMapper")
public interface GoodsMapper {
	// goods
	public String autoNum();
	public Integer goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> selectAll(StartEndPageDTO dto);
	public GoodsDTO selectOne(String goodsNum);
	public Integer goodsUpdate(GoodsDTO dto);
	public Integer goodsDel(String goodsNum);
	public Integer visitCount(String goodsNum);
	public List<GoodsDTO> searchGoods(String goodsWord);
	// 여러개 삭제
	// 1. 배열을 이용한 방법
	public Integer goodsDels(String[] deletes);
	// 2. 리스트를 이용한 방법
	public Integer goodsDeletes(List<String> cs);
	// 3. Map을 이용한 방법
	public Integer goodsRemove(Map<String, Object> condition);
	
	public int goodsCount();
	
	// 파일 여러개 삭제
	public List<GoodsDTO> goodsSelect(HashMap<String, Object> condition);
	
	
	// goodsIpgo
	public List<GoodsDTO> goodsItems(String goodsName);
	public Integer ipgoInsert(GoodsIpgoDTO dto);
	public List<GoodsIpgoDTO> ipgoSelect(StartEndPageDTO dto);
	// 1 대 1 정보 / GoodsIpgoGoodsDTO에서 GoodsDTO 하나에 GoodsIpgoDTO 하나
	// 1 대 1은 xml에서 resultMap
	public GoodsIpgoGoodsDTO ipgoDetail(GoodsIpgoDTO dto); 
	public GoodsDTO getGoodsIpgoInfo(GoodsIpgoDTO idto);
	public Integer goodsIpgoUpdate(GoodsIpgoDTO dto);
	public Integer goodsIpgoDel(GoodsIpgoCommand goodsIpgoCommand);
	// 여러개 삭제
	// 1. 리스트 사용
	public Integer goodsIpgoDels(List<String[]> condition);

	public int goodsIpgoCount();
	// 관심상품
	public Integer wishAdd(WishDTO dto);
	public String wishCount(WishDTO dto);
	// 장바구니
	public Integer cartAdd(CartDTO cart);
}
