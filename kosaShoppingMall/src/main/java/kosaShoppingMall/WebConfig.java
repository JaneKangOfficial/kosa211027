package kosaShoppingMall;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kosaShoppingMall.interceptor.CertificationInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	/* html이나 jsp문서 그리고 이미지파일인 경우 view밑에 있는 파일을 불러올 때 404 오류가 나는 것을 방지
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
	
	// Spring boot : 로그인하지 않아도 들어올 수 있는 주소 / Spring은 로그인해야 들어올 수 있는 주소
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new CertificationInterceptor())
//				.addPathPatterns("/**/*") // 모든 주소
//				.excludePathPatterns("/static/**/*")
//				.excludePathPatterns("/register/**/*")
//				.excludePathPatterns("/help/**/*")
//				.excludePathPatterns("/login/**/*");
//		// 로그인 세션이 없어도 되는 주소들을 적는다.
//	}

}