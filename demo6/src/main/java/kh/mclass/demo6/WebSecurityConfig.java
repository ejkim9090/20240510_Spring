package kh.mclass.demo6;

import org.springframework.boot.autoconfigure.security.SecurityProperties.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	// 람다문법을 써야함!
	
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// csrf ( 웹보안공격중하나) 를 방지해주는 기능 
		// default : true : post / delete / put 방식에서 csrf 토큰 발행해야서 함께 전달해야함.
		http.csrf(aaa -> aaa.disable());  //http.csrf(AbstractHttpConfigurer :: disable);
		
		// 클릭재킹 공격 방지기능 
		http.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(
	            //frameOptionsConfig -> frameOptionsConfig.deny() // 모두허락하지않음.
				frameOptionsConfig -> frameOptionsConfig.sameOrigin()  // 같은사이트만허락. - react연동, h2 console사용시
	                ));
		
		// login + logout 을 HttpSecurity 객체에게 맡김.
		http.formLogin(fr ->
				fr
				.loginPage("/my/login") //.loginPage("/login")
				.defaultSuccessUrl("/home")
				.failureUrl("/my/login?error")
				//.usernameParameter("email")
				);
		
		// ExceptionHandling ->
        // 스프링시큐리티에서 필터를 다는 방법
        // http.addFilter(filter);

        // 인터셉터
        //http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//		InMemoryUserDetailsManager
//		UserDetailsService
//		UserDetails
		
		return http.build();
	}
//	private UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//			
//	}
}
