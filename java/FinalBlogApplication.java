package final_blog.final_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class FinalBlogApplication extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FinalBlogApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FinalBlogApplication.class, args);
	}

}
