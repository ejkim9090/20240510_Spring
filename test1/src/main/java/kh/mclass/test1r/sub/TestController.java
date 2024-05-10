package kh.mclass.test1r.sub;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	//private TestService service = new TestService();
	@Autowired
	private TestService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/testget")
	//@GetMapping("/test")
	public String method1(String a,
			HttpServletRequest request,  
			HttpSession ss,
			HttpServletResponse res
			) {
		System.out.println(a);
		System.out.println(request.getParameter("a"));
		request.getSession().setAttribute("b", "세션값");
		ss.setAttribute("c", "세션2");
		
		request.setAttribute("serverTime", service.method1());
		return "home";
	}
}
