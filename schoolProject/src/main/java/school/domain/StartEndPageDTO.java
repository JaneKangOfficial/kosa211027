package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("pageDTO")
public class StartEndPageDTO {

	Long startRow;
	Long endRow;
	
}
