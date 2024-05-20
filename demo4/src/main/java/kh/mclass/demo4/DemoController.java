package kh.mclass.demo4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import kh.mclass.demo4.domain.BoardEntity;

@Controller
public class DemoController {
	@GetMapping("home")
	public String home() {
		
		return "home";
	}
	@GetMapping("board/list")
	public void boardlist(Model model, HttpSession session) {
		// DB연동
		BoardEntity dto = new BoardEntity("12", "12제목입니다.", "12내용입니다.");
		model.addAttribute("board", dto);
		BoardEntity sessionDto = new BoardEntity("00", "00session제목", "00session내용");
		session.setAttribute("demosession", sessionDto);
//		model.addAttribute("demosession", sessionDto);
		//return "home";
	}
	@GetMapping("board/{boardId}")
	public String boardRead(Model model, @PathVariable String boardId) {
		// DB연동
		System.out.println("/board/"+boardId);
		BoardEntity dto = new BoardEntity(boardId, boardId+"제목입니다.", boardId+"내용입니다.");
		model.addAttribute("board", dto);
		return "board/read";
	}
	@GetMapping("board/list/ajax")
	@ResponseBody
	public BoardEntity boardlistajax(Model model, BoardEntity paramDto) {
		// DB연동
		BoardEntity dto = new BoardEntity("12", "12제목입니다.", "12내용입니다.");
		return dto;  // toJson안써도 Json 형태로 return됨.
	}
}
