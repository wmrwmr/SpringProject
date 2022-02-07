package com.bitwin.bangbang.domain;

import java.util.Date;

import lombok.Data;

@Data
public class notice_boardVO {
	
	private Long nidx;
	private String title;
	private String content;
	private Date regdate;
	private Date updateDate;
}
