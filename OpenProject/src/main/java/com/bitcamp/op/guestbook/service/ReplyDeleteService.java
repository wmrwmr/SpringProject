package com.bitcamp.op.guestbook.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.guestbook.dao.GuestBookReplyDao;

@Service
public class ReplyDeleteService {

	private GuestBookReplyDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int deleteReply(int idx) {
		return template.getMapper(GuestBookReplyDao.class).deleteByIdx(idx);
	}
	
}











