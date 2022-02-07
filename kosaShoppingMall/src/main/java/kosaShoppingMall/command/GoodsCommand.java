package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class GoodsCommand {
	@Size(min=10, max=10, message="번호가 없습니다.")
	String goodsNum;
	@NotBlank(message="이름을 입력하세요")
	String goodsName;
	@NotNull(message="가격을 입력하세요")
	Integer goodsPrice;
	@NotBlank(message="내용을 입력하세요")
	String goodsContent;
	@NotNull(message="배송비를 입력하세요")
	Integer deliveryCost;
	Integer visitCount;
}
