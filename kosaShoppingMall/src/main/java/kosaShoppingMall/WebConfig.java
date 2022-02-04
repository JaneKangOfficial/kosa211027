package kosaShoppingMall;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	/* html이나 jsp문서에서 view밑에 있는 파일을 불러올 때 404 오류가 나는 것을 방지
	 * Spring Boot의 기본 설정이 resources/static이기 때문에 이런 설정이 없으면 static에서 찾기 때문에 404 발생
	 * webapp/view 를 사용하기 위해서 설정이 필요
	 */
	@Override
	public void addResourceHandlers(
			ResourceHandlerRegistry registry) {
		// view 밑에 파일을 슬래쉬 "/"로 불러오겠다.
		registry.addResourceHandler("/**")
        .addResourceLocations("/view/")
        .setCachePeriod(14400);
	}
	
/*	
  	// error.properties 설정 : application.properties에서 설정하거나 WebConfig에서 설정 
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("message/error");
		source.setUseCodeAsDefaultMessage(true);
		source.setDefaultEncoding("utf-8");
		return source;
	}
*/	
}