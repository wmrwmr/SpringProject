package com.bitwin.mapper;

import java.util.List;


import com.bitwin.domain.Criteria;
import com.bitwin.domain.notice_boardVO;

public interface BoardMapper {
	
//	@Select("select * from notice_board where nidx > 0") 
	public List<notice_boardVO> getList();
	
	public void insert(notice_boardVO board);
	
	public void insertSelectKey(notice_boardVO board);
	
	public notice_boardVO read(Long nidx);
	
	public int delete(Long nidx);
	
	public int update(notice_boardVO board);
	
	public List<notice_boardVO> getListWithPaging(Criteria cri);
}
