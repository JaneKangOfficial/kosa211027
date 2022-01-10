package sp4;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	// 화면에 출력하기 위해
public class App {

	// Spring Boot는 무조건 main method를 사용한다.
	@RequestMapping("/") // contextPath 다음의 주소부터 작성
	public String home() {
		return "hello world";
	}
	
	// tomcat 대신 main 사용 : run as - java application
	public static void main(String[] args) {
		SpringApplication.run(App.class, args); // App 실행
	}
}

/*
	Spring Framework = API(Application Interface)
	
	jsp						Spring	       +       Mybatis
	FrontController			Controller
	Controller				Service
	DAO						Repository      + 	    mapper
	DTO/VO					DTO/VO
	
	jsp에서
	Spring - Controller만 바뀜
	Mybatis - DAO만 바뀜
	
	
	Spring Compiler
	maven(pom.xml), gradle(gradle.xml) - xml 차이일뿐 똑같다 (maven 주로 많이 사용)
	
	
	Spring
	pom.xml - 필요로하는 Library를 자동으로 다운 받아서 저장해준다.
	
	
	Spring			Spring-Boot
	jsp + html		html (html에서도 jsp taglib를 사용할 수 있도록 제공한다. - 템플릿엔진) -> servlet
					jsp 사용을 위해서는 lib 추가
					톰캣(WAS) 사용하지 않음 - lib 추가 
 */
