package com.bitwin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum;
	private int amount;
	private int offset;
	
	public Criteria() {
		
		this(1, 10, 0);
	}
	
	public Criteria(int pageNum, int amount, int offset) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.offset = offset;
		
	}
	
	
}
