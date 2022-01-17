package springBootTest2.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.command.MemberCommand;
import springBootTest2.domain.MemberDTO;
import springBootTest2.mapper.MemberMapper;

@Component
@Service
public class MemberUpdateSerivce {
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setMemNum(memberCommand.getMemNum());
		dto.setMemName(memberCommand.getMemName());
		dto.setMemId(memberCommand.getMemId());
		dto.setMemPhone1(memberCommand.getMemPhone1());
		dto.setMemPhone2(memberCommand.getMemPhone2());
		dto.setMemAddr(memberCommand.getMemAddr());
		dto.setMemEmail(memberCommand.getMemEmail());		
		memberMapper.memberUpdate(dto);
	}
}
