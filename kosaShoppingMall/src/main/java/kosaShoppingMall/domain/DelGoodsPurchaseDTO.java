package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("delGoodsPurchaseDTO")
public class DelGoodsPurchaseDTO {

	String[][] purchaseNum;
	String[] goodsName;
}
