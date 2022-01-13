package springBootTest2;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// xml 파일을 없앤 대신 @으로 어떤 class인지 알려줘야 한다.

@Configuration 
public class DataBaseInfo {
	@Bean // 스프링에 필요한 객체를 생성한다.
	// SqlSessionFactory : Mybatis의 Connection 객체 
	// DataSource : application.properties 에 적은 내용을 자동으로 받아온다.
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
}
