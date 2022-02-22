package kosaShoppingMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("goodsInquireDTO")
public class GoodsInquireDTO {
	Integer inquireNum;
	String goodsNum;
	String memberNum;
	String inquireSubject; 
	String inquireContent;
	String inquireKind;
	String inquireAnswer;
	Date inquireDate;
	Date answerDate;
	String answerEmail;
	
	GoodsDTO goodsDTO;
	MemberDTO memberDTO;
}
