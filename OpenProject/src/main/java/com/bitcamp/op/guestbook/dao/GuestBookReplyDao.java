package com.bitcamp.op.guestbook.dao;

import com.bitcamp.op.guestbook.domain.ReplyRegRequest;

public interface GuestBookReplyDao {

	void insertReply(ReplyRegRequest regRequest);

	int deleteByIdx(int idx);

	
}
