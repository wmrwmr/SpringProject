package com.bitcamp.op.guestbook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bitcamp.op.guestbook.domain.GuestBookListMessage;
import com.bitcamp.op.guestbook.domain.PageView;
import com.bitcamp.op.guestbook.domain.ReplyListItem;

public interface GuestBookDao {

	@Select("select count(*) from guestbook")
	public int selectTotalCount();
	
	public List<GuestBookListMessage> selectList(int index, int count);
	
	public PageView selectByIdx(int idx);

	public List<ReplyListItem> selectReplyList(int idx);

}
