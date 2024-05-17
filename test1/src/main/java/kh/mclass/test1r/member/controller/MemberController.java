package kh.mclass.test1r.member.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.mclass.test1r.member.model.dto.MemberRes;
import kh.mclass.test1r.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/list")
	public void selectList(
			
			Model model
			) {
		model.addAttribute("memberlist", memberService.selectList());
//		return "member/list";
	}
	@GetMapping("/one")
	public String selectOne(
			Model model
			, String memId
			) {
		//model.addAttribute("member", memberService.selectOne(memId));
		return "member/one";
	}
	@PostMapping("/insert")
	public String insert(
			Model model
			, String memId
			) {
		//model.addAttribute("member", memberService.selectOne(memId));
		return "redirect:/login";
	}
	@PostMapping("/ajax")
	public @ResponseBody String getajax(
			Model model
			, String memId
			) {
		//model.addAttribute("member", memberService.selectOne(memId));
		return "성공했습니다. dtolist";
	}
}
