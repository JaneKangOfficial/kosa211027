package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class MemberNumService {
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(MemberCommand memberCommand, Model model) {
		String memberNum = memberMapper.memberAutoNum();
		
		// spring은 command 값을 불러올 수 없기 때문에 model에 저장
		// 그러나!!! jsp에서 modelAttribute="${memberCommand}" 적어줬을 경우 command로 사용한다.
		// model.addAttribute("memberNum", memberNum);
		
		// spring boot에서는 command에 저장
		memberCommand.setMemberNum(memberNum); 
	}
}
