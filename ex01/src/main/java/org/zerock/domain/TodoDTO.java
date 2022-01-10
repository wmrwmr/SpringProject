package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	
	private String title;
	
//	private Date dueDate; -> InitBinder를 사용할 경우
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dueDate;
	
}
