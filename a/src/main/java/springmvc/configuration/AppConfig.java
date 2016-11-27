package springmvc.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
// Add support for conversion, formatting and validation support
// <mvc:annotation-driven/>
@EnableWebMvc
@ComponentScan(basePackages = "springmvc")
public class AppConfig {

	// Define Spring MVC view resolver
	// <bean
	// class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	// <property name="prefix" value="/WEB-INF/view/" />
	// <property name="suffix" value=".jsp" />
	// /bean>
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	// @Configuration marks this class as configuration class as mentioned above
	// & ComponentScan referes to package locations to find the associated
	// beans.
	// @EnableWebMvc is equivalent to mvc:annotation-driven in XML.
	// Method viewResolver configures a view resolver to identify the real view.
}
