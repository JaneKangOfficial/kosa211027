package kosaShoppingMall.domain;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("goodsIpgoDTO")
public class GoodsIpgoDTO {
	String goodsNum;
	Date ipgoDate;
	Integer ipgoQty;
	Timestamp madeDate;
}
