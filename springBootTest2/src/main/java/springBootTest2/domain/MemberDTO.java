package springBootTest2.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {
// DTO는 컬럼명과 같아야 한다.
	String memNum;
	String memName;
	Date memRegiDate;
	String memId;
	String memPw;
	String memPhone1;
	String memPhone2;
	String memAddr;
	String memEmail;
	String memGender;
	Date memBirth;
}
