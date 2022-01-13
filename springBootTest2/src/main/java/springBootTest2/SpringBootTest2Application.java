package springBootTest2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication // 이 위치부터 설정을 읽어가며 자동설정, 최상단에 위치해야 한다. (main)
@Component(value = "springBootTest2") // springBootTest2 package 밑에 있는 파일을 다 읽겠다.
@MapperScan(value = "springBootTest2.mapper") // mapper를 scan 하겠다.
public class SpringBootTest2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTest2Application.class, args);
	}

}
