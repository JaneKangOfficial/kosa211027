package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("authInfo")
public class AuthInfo {

	String userId;
	String userPw;
	String grade;
	
	String phone;
	
	String memberOk;
}
