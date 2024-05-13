package kh.mclass.test1r.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.mclass.test1r.member.model.dao.MemberDao;
import kh.mclass.test1r.member.model.dto.MemberRes;

@Service("memberService")
@Transactional
public class MemberService {
	@Autowired 
	private MemberDao memberDao;
	
	//@Transactional
	public List<MemberRes> selectList(){
		memberDao.insert();
		memberDao.update();
		
		return memberDao.selectList();
	}
	public void insertAbc() {
		
	}
}
