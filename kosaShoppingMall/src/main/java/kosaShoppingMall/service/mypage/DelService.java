package kosaShoppingMall.service.mypage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class DelService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String execute(MemberCommand memberCommand, HttpSession session) {
		String path = "thymeleaf/membership/memberDelPw";
		MemberDTO dto = memberMapper.selectOne(memberCommand.getMemberNum());
		if(passwordEncoder.matches(memberCommand.getMemberPw(), dto.getMemberPw())) {
			session.invalidate();
			memberMapper.memberDel(memberCommand.getMemberNum());
			path = "redirect:/";
		}
		return path;
	}
}
