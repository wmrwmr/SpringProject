package com.bitcamp.op.member.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.member.dao.MemberDao;

@Service
public class MemberCheckIdService {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public String checkId(String userId) {
		dao = template.getMapper(MemberDao.class);
		return dao.selectCountByUesrId(userId)>0 ? "N" : "Y";
	}
	

}







