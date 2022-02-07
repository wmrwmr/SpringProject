package com.bitwin.bangbang.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitwin.bangbang.domain.Criteria;
import com.bitwin.bangbang.domain.notice_boardVO;
import com.bitwin.bangbang.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ =@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
//	@Test
//	public void testInsert() {
//		
//		notice_BoardVO board = new notice_BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("newbie");
//		
//		mapper.insert(board);
//		
//		log.info(board);
//		
//	}
	
	
//	@Test
//	public void testInsertSelectKey() {
//		
//		notice_BoardVO board = new notice_BoardVO();
//		board.setTitle("새로 작성하는 글 select key");
//		board.setContent("새로 작성하는 내용 selecet key");
//		board.setWriter("newbie");
//		
//		mapper.insertSelectKey(board);
//		
//		log.info(board);
//	}
	
	@Test
	public void testRead() {
		
		// 존재하는 게시물 번호로 테스트
		notice_boardVO board = mapper.read(5L);
		
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		
		log.info("DELETE COUNT: " + mapper.delete(2L));
	}
	
	@Test
	public void testUpdate() {
		
		notice_boardVO board = new notice_boardVO();
		// 실행 전 존재하는 번호인지 확인할 것
		board.setNidx(9L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
		
	}
	
	
	@Test
	public void testPaging() {
		
		Criteria cri = new Criteria();
		//10개씩 3페이지
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<notice_boardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board-> log.info(board));
		
	}
	
	
	
	
	
	
	
	
}
