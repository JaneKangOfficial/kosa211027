package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("goodsDTO")
@NoArgsConstructor
public class GoodsDTO {
	String goodsNum;
	String goodsName;
	Integer goodsPrice;
	String goodsContent;
	Integer deliveryCost;
	Integer visitCount;
	
	String goodsImages; // 이미지 storeFileName
	String goodsOriginal; // 이미지 originalFileName
	
	String goodsMain; // 대문 이미지 storeFileName
	String goodsMainOrg; // 대문 이미지 originalFileName
	
	GoodsIpgoDTO goodsIpgoDTO;
	
	public  GoodsDTO(String goodsNum) {
		this.goodsNum = goodsNum;
		
	}

	
	
	
}
