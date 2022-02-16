package kosaShoppingMall.domain;


import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("memDTO")
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	String memberNum;
	String memberId;
	String memberPw;
	String memberName;
	String memberAddr;
	Date memberRegist;
	String gender;
	String memberPhone;
	Date memberBirth;
	String memberEmail;
	String memberOk;
}
