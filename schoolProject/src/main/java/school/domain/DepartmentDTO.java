package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("departmentDTO")
public class DepartmentDTO {
	
	String departmentNum;
	String departmentName;
	String departmentPhone;
	String departmentAddr;

}
