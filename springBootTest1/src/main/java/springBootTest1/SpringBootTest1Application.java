package springBootTest1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component("springBootTest1") // springBootTest1 package 밑에 있는 파일을 다 읽겠다.
@MapperScan("springBootTest1.repository") // repository에 있는 mapper를 scan 하겠다.
public class SpringBootTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTest1Application.class, args);
	}

}
