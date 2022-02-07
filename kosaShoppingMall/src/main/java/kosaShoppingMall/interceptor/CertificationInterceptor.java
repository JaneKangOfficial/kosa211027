package kosaShoppingMall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kosaShoppingMall.domain.AuthInfo;

/*
	implements HandlerInterceptor => interface
	extends HandlerInterceptorAdapter => class
*/
public class CertificationInterceptor implements HandlerInterceptor{

	// preHandle : controller(즉 RequestMapping이 선언된 메서드 진입) 실행 직전에 동작
	// controller 들어오기 전에 차단
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 로그인이 된 후에 진입이 가능하도록 session으로 구별
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		// ObjectUtils : object가 비었는지 확인하는 메서드
		if(ObjectUtils.isEmpty(authInfo)) {
			response.sendRedirect("/");
			return false;
		}else {
			return true;
		}
	}
	
	// postHandle : 컨트롤러 진입 후 view가 랜더링 되기 전 실행되는 메서드
	// view가 열리기 전에 차단
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	// afterCompletion : 컨트롤러 진입 후 view가 정상적으로 랜더링 된 후 제일 마지막에 실행이 되는 메서드	
	// view까지 다 정상적으로 실행된 후에 차단	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
