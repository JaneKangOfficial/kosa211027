package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class MemberNumService {
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(MemberCommand memberCommand) {
		String memberNum = memberMapper.memberAutoNum();
		memberCommand.setMemberNum(memberNum);
	}
}
