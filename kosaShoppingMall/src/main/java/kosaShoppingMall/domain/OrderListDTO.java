package kosaShoppingMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("orderListDTO")
public class OrderListDTO {

	String confirmNumber;
	String purchaseNum;
	Date purchaseDate;
	String purchaseStatus;
	String goodsName;
	String goodsMain;
	String totalPrice;
	
	String goodsContent;
	String goodsPrice;
	String deliveryCost;
	String purchaseAddr;
	String purchasePhone;
	String message;
	String recieveName;
	String purchaseQty;
	String purchasePrice;
	String paymentKind;
	String paymentPrice;
	Date paymentDate;
	String cardNumber;
	
}
