package com.bitwin.bangbang.mapper;

import java.util.List;

import com.bitwin.bangbang.domain.Criteria;
import com.bitwin.bangbang.domain.notice_boardVO;

public interface BoardMapper {
	
//	@Select("select * from tbl_board where nidx > 0") -> BorderMapper.xml 로 처리완료 (아래 메소드들도 동일)
	public List<notice_boardVO> getList();
	
	public void insert(notice_boardVO board);
	
	public void insertSelectKey(notice_boardVO board);
	
	public notice_boardVO read(Long nidx);
	
	public int delete(Long nidx);
	
	public int update(notice_boardVO board);
	
	public List<notice_boardVO> getListWithPaging(Criteria cri);
}
