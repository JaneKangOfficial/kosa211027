package kosaShoppingMall.service.memberJoin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import kosaShoppingMall.command.LoginCommand;
import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.MemberMapper;

@Component
@Service
public class MemberLoginService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	GoodsMapper goodsMapper;
	
	public String execute(LoginCommand loginCommand, BindingResult result, HttpSession session, Model model) {
		List<GoodsDTO> list = goodsMapper.selectAll(new StartEndPageDTO());
		model.addAttribute("lists", list);
		
		String path = "thymeleaf/index";
		AuthInfo authInfo = memberMapper.loginSelect(loginCommand.getUserId());
		if(authInfo != null) {
			
			if(authInfo.getMemberOk() == null && authInfo.getGrade().equals("mem")) {
				result.rejectValue("userId", "loginCommand.userId", "이메일을 확인해주세요.");
				return path;
			}
			
			if(passwordEncoder.matches(loginCommand.getUserPw(), authInfo.getUserPw())) {
				session.setAttribute("authInfo", authInfo);
				path = "redirect:/";
			}else {
				result.rejectValue("userPw", "loginCommand.userPw", "비밀번호 다릅니다.");
			}
		}else {
			result.rejectValue("userId", "loginCommand.userId", "아이디가 존재하지 않습니다.");
		}
		return path;
	}
}
