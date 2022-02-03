package kosaShoppingMall.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class ModifyService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String execute(MemberCommand memberCommand, BindingResult result) {
		String path = "thymeleaf/membership/memberModify";

		MemberDTO dto = memberMapper.selectOne(memberCommand.getMemberNum());
		
		if(passwordEncoder.matches(memberCommand.getMemberPw(), dto.getMemberPw())) {
			System.out.println("oooooooooooooooooooo");
			
			dto.setMemberNum(memberCommand.getMemberNum());
			dto.setMemberId(memberCommand.getMemberId());
			dto.setMemberName(memberCommand.getMemberName());
			dto.setMemberBirth(memberCommand.getMemberBirth());
			dto.setGender(memberCommand.getGender());
			dto.setMemberEmail(memberCommand.getMemberEmail());
			dto.setMemberAddr(memberCommand.getMemberAddr());
			dto.setMemberPhone(memberCommand.getMemberPhone());
			
			memberMapper.memberModify(dto);
			path = "thymeleaf/membership/memberDetail";
		}else {
			System.out.println("xxxxxxxxxxxxxxxxxxxx");
			result.rejectValue("memberPw", "memberCommand.memberPw", "비밀번호 다릅니다.");
		}
		return path;
	}
}
