package kh.mclass.test1r.sub;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kh.mclass.test1r.sub.model.dto.TestDto;

@Controller
public class TestController {
	//private TestService service = new TestService();
	@Autowired
	private TestService testService;
	
	@Autowired
	@Qualifier(value = "testDto3")
	private TestDto testDto3;
	
	@Value("testDto3.a2")
	private String testA2;	
	
	
	//@RequestMapping(method = RequestMethod.GET, path = "/testget")
	@GetMapping("/test")
	public String method1(
			@RequestParam(defaultValue = "aaa", required = false, name = "a") String b,
			HttpServletRequest request,  
			HttpSession ss,
			HttpServletResponse res
			) {
		
		System.out.println("여기서 testDto Bean 확인하기");
		System.out.println(testDto3);
		System.out.println(testA2);
		
		
		System.out.println(b);
		System.out.println(request.getParameter("a"));
		request.getSession().setAttribute("b", "세션값");
		ss.setAttribute("c", "세션2");
		
		request.setAttribute("serverTime", testService.method1());
		return "home";
	}
}
