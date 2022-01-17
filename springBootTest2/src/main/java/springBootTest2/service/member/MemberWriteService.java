package springBootTest2.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.command.MemberCommand;
import springBootTest2.domain.MemberDTO;
import springBootTest2.mapper.MemberMapper;

@Component
@Service
public class MemberWriteService {
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(MemberCommand memberCommand, Model model) {
		MemberDTO dto = new MemberDTO();
		dto.setMemNum(memberCommand.getMemNum());
		dto.setMemName(memberCommand.getMemName());
		dto.setMemBirth(memberCommand.getMemBirth());
		dto.setMemGender(memberCommand.getMemGender());
		dto.setMemId(memberCommand.getMemId());
		dto.setMemPw(memberCommand.getMemPw());
		dto.setMemPhone1(memberCommand.getMemPhone1());
		dto.setMemPhone2(memberCommand.getMemPhone2());
		dto.setMemAddr(memberCommand.getMemAddr());
		dto.setMemEmail(memberCommand.getMemEmail());

		System.out.println("aaaaaa " + dto.getMemNum());
		memberMapper.memberInsert(dto);
		model.addAttribute("dto", dto);
		
	}
	
}
