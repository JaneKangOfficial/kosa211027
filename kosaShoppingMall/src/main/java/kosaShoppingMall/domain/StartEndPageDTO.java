package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("startEndPageDTO")
public class StartEndPageDTO {

	Long startRow;
	Long endRow;
}