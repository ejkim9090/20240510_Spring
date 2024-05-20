package kh.mclass.demo3.board.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BoardEntity {
	private String boardId;
	private String subject;
	private String writeTime; 
	private String boardWriter;
	private Integer readCount;
}
