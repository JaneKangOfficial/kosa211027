package kosaShoppingMall.service.goods;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.mapper.GoodsMapper;
import kosaShoppingMall.mapper.LoginMapper;

@Service
public class GoodsListPageService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	LoginMapper loginMapper;
	
	public void execute(HttpServletRequest request) {
		List<GoodsDTO> list = goodsMapper.selectAll(new StartEndPageDTO());
		//model.addAttribute("lists", list);
		request.setAttribute("lists", list);
		
		// Cookie
		Cookie[] cookies = request.getCookies(); // 쿠키 찾아오기
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().startsWith("id")) {
					request.setAttribute("isId", cookie.getValue());
				}
				if(cookie.getName().startsWith("auto")) {
					AuthInfo authInfo = 
							//loginMapper.loginSelect(cookie.getValue());
					loginMapper.checkId(cookie.getValue());
					HttpSession session = request.getSession();
					session.setAttribute("authInfo", authInfo);
				}
			}
		}
	}
}
