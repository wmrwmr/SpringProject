package com.bitwin.bangbang;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bitwin.domain.notice_boardVO;
import com.bitwin.domain.Criteria;

import com.bitwin.mapper.notice_boardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class notice_boardMapperTests {
	
	@Setter(onMethod_ =@Autowired)
	private notice_boardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(notice_board -> log.info(notice_board));
//	}
	
//	@Test
//	public void testInsert() {
//		
//		notice_boardVO notice_board = new notice_boardVO();
//		notice_board.setTitle("새로 작성하는 글");
//		notice_board.setContent("새로 작성하는 내용");
//		notice_board.setWriter("newbie");
//		
//		mapper.insert(notice_board);
//		
//		log.info(notice_board);
//		
//	}
	
	
//	@Test
//	public void testInsertSelectKey() {
//		
//		notice_boardVO notice_board = new notice_boardVO();
//		notice_board.setTitle("새로 작성하는 글 select key");
//		notice_board.setContent("새로 작성하는 내용 selecet key");
//		notice_board.setWriter("newbie");
//		
//		mapper.insertSelectKey(notice_board);
//		
//		log.info(notice_board);
//	}
	
//	@Test
//	public void testRead() {
//		
//		// 존재하는 게시물 번호로 테스트
//		notice_boardVO notice_board = mapper.read(5L);
//		
//		log.info(notice_board);
//	}
//	
//	@Test
//	public void testDelete() {
//		
//		log.info("DELETE COUNT: " + mapper.delete(2L));
//	}
//	
//	@Test
//	public void testUpdate() {
//		
//		notice_boardVO notice_board = new notice_boardVO();
//		// 실행 전 존재하는 번호인지 확인할 것
//		notice_board.setBno(9L);
//		notice_board.setTitle("수정된 제목");
//		notice_board.setContent("수정된 내용");
//		notice_board.setWriter("user00");
//		
//		int count = mapper.update(notice_board);
//		log.info("UPDATE COUNT: " + count);
//		
//	}
//	
//	
//	@Test
//	public void testPaging() {
//		
//		Criteria cri = new Criteria();
//		//10개씩 3페이지
//		cri.setPageNum(3);
//		cri.setAmount(10);
//		
//		List<notice_boardVO> list = mapper.getListWithPaging(cri);
//		
//		list.forEach(notice_board-> log.info(notice_board));
//		
//	}
	
	
	@Test
	public void testSearch() {
		
		Criteria cri = new Criteria();
		
		cri.setKeyword("d");
		cri.setType("TC");
		
		List<notice_boardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(notice_board -> log.info(notice_board));
		
	}
	
	
	
	
	
}
