package kh.mclass.demo8;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Demo8Controller {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/emp")
	public String empList() {
		return "home";
	}
	
	@GetMapping("/emp/find")
	public String findEmp(String ename) {
		return "home";
	}

	@PostMapping("/emp")
	public String insert(String empno, String ename, String deptno) {
		return "home";
	}
}
