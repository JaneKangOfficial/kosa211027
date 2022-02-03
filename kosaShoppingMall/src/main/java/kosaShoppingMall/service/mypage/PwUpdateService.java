package kosaShoppingMall.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class PwUpdateService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	public String execute(MemberCommand memberCommand, Model model) {
		String path = "thymeleaf/membership/memberPwUpdate";
		MemberDTO dto = memberMapper.selectOne(memberCommand.getMemberNum());
		
		System.out.println("111111 " + passwordEncoder.matches(dto.getMemberPw(), memberCommand.getOldPw()));
		System.out.println("222222 " + memberCommand.getOldPw());
		System.out.println("333333 " + memberCommand.getNewPw());
		
		if(passwordEncoder.matches(memberCommand.getOldPw(), dto.getMemberPw())) {
			dto.setMemberNum(memberCommand.getMemberNum());
			String memPw = passwordEncoder.encode(memberCommand.getNewPw());
			dto.setMemberPw(memPw);
			memberMapper.pwUpdate(dto);
			model.addAttribute("memberCommand", dto);
			path = "thymeleaf/membership/memberDetail";
			
		}
		return path;
	}
}
