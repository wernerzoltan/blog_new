package final_blog.final_blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		super.addViewControllers(registry);
		registry.addViewController("/login").setViewName("auth/login"); //ha a /login-t keresik, akor az auth/login mappában találják meg
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
	}
	

}