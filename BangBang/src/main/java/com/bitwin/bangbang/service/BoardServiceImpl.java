package com.bitwin.bangbang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitwin.bangbang.domain.Criteria;
import com.bitwin.bangbang.domain.notice_boardVO;
import com.bitwin.bangbang.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	//Spring 4.3 이상에서 자동 처리
	private BoardMapper mapper;
	
	@Override
	public void register(notice_boardVO board) {
		log.info("register......" + board);
		mapper.insertSelectKey(board);
		
	}
	
	@Override
	public List<notice_boardVO> getList(Criteria cri) {
		log.info("get List with criteria: " + cri);
		
		return mapper.getListWithPaging(cri);
		
	}
	
	@Override
	public notice_boardVO get(Long nidx) {
		
		log.info("get......" + nidx);
		
		return mapper.read(nidx);
		
	}
	
	@Override
	public boolean modify(notice_boardVO board) {
		
		log.info("modify....." + board);
		
		return mapper.update(board) == 1;
		
	}
	
	@Override
	public boolean remove(Long nidx) {
		
		log.info("remove...." + nidx);
		
		return mapper.delete(nidx)==1;
	}
	
	
	
	
	
	
	
	
}
