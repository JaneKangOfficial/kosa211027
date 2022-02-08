package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.GoodsIpgoDTO;
import lombok.Data;

@Data
@Alias("goodsIpgoGoodsDTO")
public class GoodsIpgoGoodsDTO {
	// xml에 property는 멤버필드명
	GoodsDTO goodsDTO;
	GoodsIpgoDTO goodsIpgoDTO;
}
