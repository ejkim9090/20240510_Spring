package kh.mclass.demo4.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@Component
public class LoginInterceptor implements HandlerInterceptor {
	
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

}
