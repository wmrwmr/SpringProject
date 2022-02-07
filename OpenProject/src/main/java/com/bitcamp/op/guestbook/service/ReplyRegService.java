package com.bitcamp.op.guestbook.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.guestbook.dao.GuestBookReplyDao;
import com.bitcamp.op.guestbook.domain.ReplyRegRequest;

@Service
public class ReplyRegService {

	private GuestBookReplyDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public void insertReply(ReplyRegRequest regRequest) {
		
		dao = template.getMapper(GuestBookReplyDao.class);
		
		dao.insertReply(regRequest);
		
	}
	
	
}









