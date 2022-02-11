package kosaShoppingMall.service.help;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.FindIdCommand;
import kosaShoppingMall.mapper.LoginMapper;

@Service
public class FindIdByEmailService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	private JavaMailSender mailSender;
	
	public String execute(FindIdCommand findIdCommand, BindingResult result) {
		// 메일로 id 찾기
		String userId = loginMapper.findIdByEmail(findIdCommand);
		if(userId == null) {
			result.rejectValue("memberPhone", "findPasswordCommand.memberPhone", "정보가 부족합니다.");
			return "thymeleaf/help/findId";
		}else {
			// 메일링 -----------
			// 메일정보저장
			MimeMessage msg = mailSender.createMimeMessage();
			String content = "<html><body>" + "안녕하세요. Kosa쇼핑몰입니다.<br /> 아이디는 <strong>[ "+ userId +" ]</strong> 입니다. </body></html>";
			String subject = "KosaShoppingMall 아이디 찾기";
			
			try {
				msg.setHeader("conent-type", "text/html; charset=UTF-8");
				msg.setContent(content, "text/html; charset=UTF-8");
				msg.setSubject(subject);
				msg.setFrom(new InternetAddress("sender@gmail.com"));
				msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(findIdCommand.getMemberEmail()));
				mailSender.send(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "thymeleaf/help/findIdOk";
		}
	}
}
