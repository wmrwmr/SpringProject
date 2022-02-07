package com.bitcamp.op.guestbook.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.guestbook.dao.GuestBookDao;
import com.bitcamp.op.guestbook.domain.PageView;

@Service
public class GuestBookPageViewService {
	
	private GuestBookDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public PageView getPageView(int idx) {
		
		return template.getMapper(GuestBookDao.class).selectByIdx(idx);
	}
}
