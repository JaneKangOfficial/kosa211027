package springTest.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 파일을 전달 , html 문서
public class TestController {
	@RequestMapping("/hello")
	public String test() {
		// pom.xml : 필요한 lib 자동으로 다운로드 받아준다. 만약 안되면 "WEB-INF/lib" 폴더에 직접 붙여넣기
		// pom.xml에 html 파일 설정 (taglib가 아닌 thymeleaf library 사용하는것)
		return "thymeleaf/test/hello";
		// application.properties : 경로를 알려준다.
	}

}
