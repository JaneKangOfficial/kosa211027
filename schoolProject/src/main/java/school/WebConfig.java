package school;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// extends 일 경우 Adapter(는 무조건 class)
// public class WebConfig extends WebMvcConfigurerAdapter{

// implements 일 경우 WebMvcConfigurer(는 interface)
@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
				.addResourceLocations("/view/")
				.setCachePeriod(14400); // 시간설정(초), (14400 % 60 = 초)
	}
	
	// error.properties 설정 : application.properties에서 설정하거나 WebConfig에서 설정
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("message/error");
		source.setUseCodeAsDefaultMessage(true);
		source.setDefaultEncoding("utf-8");
		return source;
	}
	
}
