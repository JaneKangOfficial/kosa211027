package springBootTest2.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {
	// Command는 html name과 같아야 한다.
	String memNum;
	String memName;
	// html에서 command로 넘어올 때 DateTimeFormat이 꼭 필요하다.
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memBirth;
	String memGender;
	String memId;
	String memPw;
	String memPwCon; // DTO에는 없지만 html에는 있으니 command에도 있어야 한다.
	String memPhone1;
	String memPhone2;
	String memAddr;
	String memEmail;
}