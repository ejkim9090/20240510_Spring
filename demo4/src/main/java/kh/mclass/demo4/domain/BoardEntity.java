package kh.mclass.demo4.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// tostring,get,set
@Data
@AllArgsConstructor
//@NoArgsConstructor
//@Component
//@RequiredArgsConstructor
public class BoardEntity {
//	@NonNull
	private String boardId;
	
//	@NonNull
	private String boardTitle;
	
	private String boardContent;
	
}
