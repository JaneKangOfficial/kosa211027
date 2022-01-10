package springTest.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController : 파일이 아닌 문자 전달 controller
/*
	 RestController가 필요한 이유 (안드로이드에서 사용)
	 안드로이드(앱)는 db에 직접 접근이 불가능(ojdbc.jar를 설치해야 하지만 설치할 수 있는 기능이 없다.)
	 db에 접속하기 위해서는 ojdbc.jar가 있는 web(spring(db), jsp(db))에 연결해야 한다.
	 html은 웹브라우저이다. 앱에는 없다.
	 spring, jsp에서 문자열로 서비스해야 안드로이드에서 볼 수 있다. (json 문자열 방식)
 */
public class HelloController {
	@RequestMapping("/")
	public String home() {
		return "hello controller";
	}

}
