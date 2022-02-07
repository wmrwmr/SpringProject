package com.bitwin.service;

import java.util.List;

import com.bitwin.domain.Criteria;
import com.bitwin.domain.notice_boardVO;

public interface BoardService {
	
	
	public void register(notice_boardVO board);
	
	public notice_boardVO get(Long nidx);
	
	public boolean modify(notice_boardVO board);
	
	public boolean remove(Long nidx);
	
	public List<notice_boardVO> getList(Criteria cri);
	
	
}
