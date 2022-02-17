package kosaShoppingMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("purchaseDTO")
public class PurchaseDTO {
	String purchaseNum;
	Date purchaseDate;
	Long totalPrice;
	String purchaseAddr;
	String purchasePhone;
	String message;
	String purchaseStatus; // 구매확인되면 리버튼이 활성화
	String memberNum;
	String recieveName;
	
}
