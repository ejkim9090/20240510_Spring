package kh.mclass.demo3.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.mclass.demo3.board.domain.BoardEntity;
import kh.mclass.demo3.board.model.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRespository;
	
	public List<BoardEntity> selectAll(){
		return boardRespository.selectAllList();
	}
}
