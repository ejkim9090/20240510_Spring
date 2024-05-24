package kh.mclass.demo4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Configuration
@EnableWebMvc
public class MyConfiguration implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				System.out.println("ㅎㅎㅎㅎ");
				// session 객체를 가져옴
				HttpSession session = request.getSession();
				// login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
				Object obj = session.getAttribute("sslogin");

				// 로그인이 되어있지 않음 상태
				if (obj == null) {
					response.sendRedirect(request.getContextPath()+"/login");
					// 더이상 컨트롤러 요청으로 가지 않도록 false로 반환
					return false;
				}else {
					// preHandle의 return은 컨트롤러 요청 uri로 가도 되냐 안되냐를 허가하는 의미임
					// 따라서 true로하면 컨트롤러 uri로 가게 됨.
					return true;
				}
			}
		})
				.addPathPatterns("/**")
				.excludePathPatterns("/login")
				.excludePathPatterns("/join")
				.excludePathPatterns("/main/*")
				.excludePathPatterns("/login")
				.excludePathPatterns("/css/**", "/js/**", "/image/**", "/html/**")
				;
	}
	// '/css' 경로로 요청하는 모든 정적 파일을 코드 베이스의 '/static/css' 경로에서 찾는 예시
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").
				addResourceLocations("classpath:/static/css");
		registry.addResourceHandler("/js/**").
				addResourceLocations("classpath:/static/js");
		registry.addResourceHandler("/html/**").
				addResourceLocations("classpath:/static/html");
		registry.addResourceHandler("/image/**").
				addResourceLocations("classpath:/static/image");

	}
	

	@Bean
	public Object mybean() {
		Object retObj = null;

		return retObj;
	}
}
