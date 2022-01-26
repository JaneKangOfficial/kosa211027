package kosaShoppingMall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // 자동 생성
@ComponentScan(value = "kosaShoppingMall")
@MapperScan(value = {"kosaShoppingMall"})
//@RestController // test 하기 위해서
@Controller
public class KosaShoppingMallApplication {
	@RequestMapping("/")
	public String test() {
		return "thymeleaf/index";
	}
	public static void main(String[] args) {
		SpringApplication.run(KosaShoppingMallApplication.class, args);
	}
}