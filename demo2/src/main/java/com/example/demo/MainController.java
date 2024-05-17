package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("m1", "m1 값");
		return "aaa";
		
	}
	
}
