package com.bitcamp.op.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.member.domain.LoginParams;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.domain.SearchParams;

@Repository
public class mybatisMemberDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	
	private final String NAME_SPACE = "com.bitcamp.op.member.dao.mapper.MemberMapper";
	
	public Member selectByIdPw(LoginParams prams) {
		return session.selectOne(NAME_SPACE+".selectByIdPw", prams);
	}
	
	public int selectTotalCount() {
		return session.selectOne(NAME_SPACE+".selectTotalCount");
	}
	
	public List<Member> selectList(SearchParams params){
		return session.selectList(NAME_SPACE+".selectList", params);
	}
	
	public int insert(MemberRegRequest regRequest) {
		return session.update(NAME_SPACE+".insertMember", regRequest);
	}
	
	public Member selectByIdx(int idx) {
		return session.selectOne(NAME_SPACE+".selectByIdx", idx);
	}

}










