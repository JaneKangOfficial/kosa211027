package kosaShoppingMall;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class DataBaseInfo {
	// interface, class 사용시 필요
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource, 
			ApplicationContext applicationContext)
			throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		
		// interface와 xml 파일이 같은 package에 있을 경우 설정할 필요가 없다.
		// ** 표시 : mappers/**/ : mappers 밑에 폴더가 있을 수도 있다는 표시
		sessionFactory.setMapperLocations(applicationContext.getResources("classpath:mappers/**/*Mapper.xml"));
		
		// 여기에서만 별칭을 사용할 수 있다.
		sessionFactory.setTypeAliasesPackage("kosaShoppingMall.domain");
		return sessionFactory.getObject();
	}

	// class 사용시 꼭 필요
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}