package springBootTest2.service.membership;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.MemberCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.MemberDTO;
import springBootTest2.mapper.MembershipMapper;

@Component
@Service
public class MemberUpdateService2 {
	@Autowired
	MembershipMapper membershipMapper;
	
	public String execute(MemberCommand memberCommand, HttpSession session) {
		String path = null;
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		if(authInfo.getUserPw().equals(memberCommand.getMemPw())) {
			MemberDTO dto = new MemberDTO();
			dto.setMemNum(memberCommand.getMemNum());
			dto.setMemName(memberCommand.getMemName());
			dto.setMemPw(memberCommand.getMemPw());
			dto.setMemPhone1(memberCommand.getMemPhone1());
			dto.setMemPhone2(memberCommand.getMemPhone2());
			dto.setMemAddr(memberCommand.getMemAddr());
			dto.setMemEmail(memberCommand.getMemEmail());
			dto.setMemGender(memberCommand.getMemGender());
			dto.setMemBirth(memberCommand.getMemBirth());
			Integer i = membershipMapper.memberUpdate(dto);
			System.out.println(i + "개 행이(가) 수정되었습니다.");
			
			path = "redirect:memInfo";
			session.removeAttribute("err_pw"); // session을 지워줘야 "err_pw"가 지워진다. (브라우저를 닫을 때까지 존재)
		}else {
			session.setAttribute("err_pw", "비밀번호가 틀렸습니다."); // model 대신 session을 사용 
			path = "redirect:memberInfoModify"; // model을 사용하려면 html(redirect가 아닌 thymeleaf)로 return 해야 한다.
		}
		return path;
	}
}
