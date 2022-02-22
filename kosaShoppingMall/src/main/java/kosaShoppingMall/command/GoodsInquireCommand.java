package kosaShoppingMall.command;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsInquireCommand {

	Integer inquireNum;
	String inquireSubject;
	String inquireContent;
	String hchkQueryType;
	String inquireAnswer;
	Date inquireDate;
	String memberNum;
	String goodsNum;
	String email1;
	String email2;
}
