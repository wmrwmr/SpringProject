package com.bitcamp.op.guestbook.domain;

public class ReplyRegRequest {

	private int idx;
	private int memberIdx;
	private int guestbookIdx;
	private String message;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public int getGuestbookIdx() {
		return guestbookIdx;
	}

	public void setGuestbookIdx(int guestbookIdx) {
		this.guestbookIdx = guestbookIdx;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ReplyRegRequest [idx=" + idx + ", memberIdx=" + memberIdx + ", guestbookIdx=" + guestbookIdx
				+ ", message=" + message + "]";
	}

}
