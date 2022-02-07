package com.bitcamp.op.guestbook.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.guestbook.dao.GuestBookDao;
import com.bitcamp.op.guestbook.domain.GuestBookListMessage;
import com.bitcamp.op.guestbook.domain.GuestBookListView;

@Service
public class GuestBookListService {

	private GuestBookDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	// 페이지 당 노출할 메시지의 수
	private final int COUNT_PER_PAGE = 5;
	// 페이징 번호 노출 개수
	private final int COUNT_PER_PAGING_NUM = 5;
	
	public GuestBookListView  getPage(int currentPage) {
		
		dao = template.getMapper(GuestBookDao.class);
		
		// 전체 회원 수
		int totalCount = dao.selectTotalCount();
				
		int index = (currentPage - 1) * COUNT_PER_PAGE;
		// 화면에 노출할 메시지
		List<GuestBookListMessage> list = dao.selectList(index, COUNT_PER_PAGE);
		
		return new GuestBookListView(currentPage, COUNT_PER_PAGE, COUNT_PER_PAGING_NUM, list, totalCount);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
