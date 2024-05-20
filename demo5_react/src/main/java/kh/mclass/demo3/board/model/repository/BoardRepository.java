package kh.mclass.demo3.board.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.mclass.demo3.board.domain.BoardEntity;

@Mapper
public interface BoardRepository{
	public List<BoardEntity> selectAllList();
}

//@Repository
//public class BoardRepository {
//	@Autowired
//	private SqlSession session;
//	
//	public List<BoardEntity> selectAll(){
//		return session.selectList("namespace.id");
//	}
//}
