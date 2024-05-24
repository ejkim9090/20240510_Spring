package kh.mclass.demo6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
//@RequestMapping("/shop")
public class TestController {

	@GetMapping("/my/test1")
	public String test1(Model model) {
		model.addAttribute("joinDto", new JoinDto());
		return "test1";
	}
	
	
	@PostMapping("/my/test1")
	public String test2( @Valid JoinDto dto, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			System.out.println("오류");
            return "test1";
        }
		model.addAttribute("aaamsg", "성공했습니다.");
		return "test1";
	}
}
