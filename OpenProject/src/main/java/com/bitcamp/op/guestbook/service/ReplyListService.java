package com.bitcamp.op.guestbook.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.guestbook.dao.GuestBookDao;
import com.bitcamp.op.guestbook.domain.ReplyListItem;

@Service
public class ReplyListService {

	private GuestBookDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public List<ReplyListItem> getList(int idx) {

		return template.getMapper(GuestBookDao.class).selectReplyList(idx);
	}

}
