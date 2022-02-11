package kosaShoppingMall.service.help;

import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.FindPasswordCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.mapper.EmployeeMapper;
import kosaShoppingMall.mapper.LoginMapper;
import kosaShoppingMall.mapper.MemberMapper;

@Service
public class FindPwService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	EmployeeMapper employeeMapper;

	public String execute(FindPasswordCommand findPasswordCommand, BindingResult result) {
		String grade = loginMapper.findPw(findPasswordCommand);
		if(grade == null) {
			result.rejectValue("userId", "findPasswordCommand.userId", "정보가 부족합니다.");
			return "thymeleaf/help/findPw";
		}else {
			// 메일링 -----------
			// 임시 비밀번호 생성 (UUID -> substring -> passwordEncoder)
			String tempPw = UUID.randomUUID().toString().substring(0, 7);
			String pw = passwordEncoder.encode(tempPw);
			System.out.println("tempPw : " + tempPw);
			
			// id, pw 저장
			AuthInfo authInfo = new AuthInfo();
			authInfo.setUserId(findPasswordCommand.getUserId());
			authInfo.setUserPw(pw);
			
			// pw 변경
			if(grade.equals("mem")) {
				memberMapper.changPw(authInfo);
			}else if(grade.equals("emp")) {
				employeeMapper.changPw(authInfo);
			}
			
			// 메일정보저장
			MimeMessage msg = mailSender.createMimeMessage();
			String content = "<html><body>" + "안녕하세요. Kosa쇼핑몰입니다.<br /> '" 
							+ findPasswordCommand.getUserId() + "'님의 임시 비밀번호는 <strong>[" 
							+ tempPw + "]</strong> 입니다.<br /> 반드시 로그인 후 비밀번호를 변경해주세요. "
							+ "</body></html>";
			String subject = "KosaShoppingMall 임시비밀번호";
			try {
				msg.setHeader("content-type","text/html; charset=UTF-8");
				// 내용을 담아서 보냄
				msg.setContent(content, "text/html; charset=UTF-8"); // 내용
				msg.setSubject(subject); // 제목
				msg.setFrom(new InternetAddress("sender@gmail.com")); // 보내는 사람
				msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(findPasswordCommand.getUserEmail())); // 받는 사람
				mailSender.send(msg); // 전송
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 메일링 끝 -----------
			return "thymeleaf/help/findPwOk";
		}
	}
}
