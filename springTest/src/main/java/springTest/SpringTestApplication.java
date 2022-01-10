package springTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @RestController : 파일이 아닌 문자 전달 controller
@SpringBootApplication // 자동으로 controller를 읽어들인다. @Controller, @RestController를 찾는다. (jsp처럼 web.xml에 controller를 적지 않아도 된다.)
public class SpringTestApplication {
/*
	@RequestMapping("/")
	String aaa() {
		// requestDispatcher 전부 생략하고 return으로 사용
		return "hello world"; // 특정값(문자열) 출력시 RestController
	} // aaa() 지우고 새로운 Controller (HelloController) 작성해서 실행해도 된다. 
*/
	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}

}
