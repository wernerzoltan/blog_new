package final_blog.final_blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private UserDetailsService userDetailsService;
		
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity httpSec) throws Exception {
		
		httpSec
			.authorizeRequests() //az alábbiakat engedélyezzük
				.antMatchers("/createposts/**")				
					.authenticated()
																
				//.anyRequest().authenticated() //minden kéréshez autentikálni kell
			.and()
				.formLogin() //a login oldal elérését lehetővétesszük
					.loginPage("/login") //a login oldalra irányítson minket
					.permitAll() //mindenki számára
			.and()
				.logout()
					.logoutSuccessUrl("/login?logout") //a login oldalra irányítson vissza a logout paraméterrel
					.permitAll();
	}
	
	
}