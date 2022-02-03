package kosaShoppingMall.service.mypage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class DetailService {
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(HttpSession session, Model model) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		
		MemberDTO dto = memberMapper.selectOneById(memId);
		model.addAttribute("memberCommand", dto);
		
	}
}
