package kosaShoppingMall.service.memberJoin;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
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
	
	public String execute(LoginCommand loginCommand, BindingResult result, 
			HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		List<GoodsDTO> list = goodsMapper.selectAll(new StartEndPageDTO());
		//model.addAttribute("lists", list);
		request.setAttribute("lists", list);
		
		String path = "thymeleaf/index";
		AuthInfo authInfo = memberMapper.loginSelect(loginCommand.getUserId());
		if(authInfo != null) {
			
//			if(authInfo.getMemberOk() == null && authInfo.getGrade().equals("mem")) {
//				result.rejectValue("userId", "loginCommand.userId", "이메일을 확인해주세요.");
//				return path;
//			}
			
			if(passwordEncoder.matches(loginCommand.getUserPw(), authInfo.getUserPw())) {
				session.setAttribute("authInfo", authInfo);
				
				// 자동 로그인
				if(loginCommand.getAutoLogin() != null && loginCommand.getAutoLogin()) {
					Cookie cookie = new Cookie("autoLogin", authInfo.getUserId()); // cookie(name,value)
					cookie.setPath("/"); // 쿠키 저장경로
					cookie.setMaxAge(60*60*24*30); // 30일동안 존재
					response.addCookie(cookie); // 사용자에게 전달
				}
				
				// 쿠키 : 사용자 컴퓨터에 저장(때문에 파일(텍스트)만 저장 가능)
				if(loginCommand.getIdStore() != null && loginCommand.getIdStore()) {
					// authInfo는 클래스(메모리객체)이기 때문에 파일에 저장 불가능 -> 메모리 안에 있는 텍스트만 저장
					Cookie cookie = new Cookie("idStore", authInfo.getUserId()); // cookie(name,value)
					cookie.setPath("/"); // 쿠키 저장경로
					cookie.setMaxAge(60*60*24*30); // 30일동안 존재(생략해도 기본 30일)
					response.addCookie(cookie); // 사용자에게 전달
				} else {
					Cookie cookie = new Cookie("idStore", ""); 
					cookie.setPath("/"); //
					cookie.setMaxAge(0); // 쿠키 삭제
					response.addCookie(cookie); // 
				}
				
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
