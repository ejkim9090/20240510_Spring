package kh.mclass.demo4;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import kh.mclass.demo4.domain.BoardEntity;

@Controller
public class DemoController {
//	@Autowired
//	private CrawlingHotel crawlingHotel;
	
	@GetMapping("crwaling/start")
	public String crwalingStart() {
		new CrawlingHotel().run();
		return "home";
	}
	
	
	@GetMapping("common/header")
	public void commonHeader() {
	}
	@GetMapping("home")
	public String home() {
		
		return "home";
	}
	@GetMapping("board/list")
	public void boardlist(Model model) {
		// DB연동
		List<BoardEntity> boardlist = new ArrayList<>();
		for(int i=0; i<10; i++) {
			BoardEntity dto = new BoardEntity(i+"", i+"제목입니다.", i+"내용입니다.");
			boardlist.add(dto);
		}
		model.addAttribute("boardlist", boardlist);
//		return "board/list";
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
