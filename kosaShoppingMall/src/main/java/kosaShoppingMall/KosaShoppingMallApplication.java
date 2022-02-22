package kosaShoppingMall;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kosaShoppingMall.command.LoginCommand;
import kosaShoppingMall.service.goods.GoodsListPageService;

@SpringBootApplication // 자동 생성
@ComponentScan(value = "kosaShoppingMall")
@MapperScan(value = {"kosaShoppingMall"})
//@RestController // test 하기 위해서
@Controller
public class KosaShoppingMallApplication {
	@Autowired
	GoodsListPageService goodsListPageService;
	@ModelAttribute
	public LoginCommand getLoginCommand() {
		return new LoginCommand();
	}
	
	@RequestMapping("/")
	public String test(HttpServletRequest request) {
		goodsListPageService.execute(request);
		return "thymeleaf/index";
	}
	public static void main(String[] args) {
		SpringApplication.run(KosaShoppingMallApplication.class, args);
	}
}