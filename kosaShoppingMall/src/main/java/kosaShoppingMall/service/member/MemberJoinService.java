package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class MemberJoinService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(MemberCommand memberCommand) {
		String memPw = passwordEncoder.encode(memberCommand.getMemberPw());
		
		MemberDTO dto = new MemberDTO();
		
		dto.setMemberNum(memberCommand.getMemberNum());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberPw(memPw);
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setGender(memberCommand.getGender());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberPhone(memberCommand.getMemberPhone());
		dto.setMemberRegist(memberCommand.getMemberRegist());
		
		System.out.println("dtoooooooooo " + dto);
		
		memberMapper.memberJoin(dto);
		
	}
}
