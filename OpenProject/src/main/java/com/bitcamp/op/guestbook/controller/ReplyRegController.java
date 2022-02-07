package com.bitcamp.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.op.guestbook.domain.ReplyRegRequest;
import com.bitcamp.op.guestbook.service.ReplyRegService;

@Controller
public class ReplyRegController {
	
	@Autowired
	private ReplyRegService regService;
	
	@PostMapping("/guestbook/reply/write")
	@ResponseBody
	public String regReply(
			ReplyRegRequest regRequest
			) {
		
		regService.insertReply(regRequest);
		
		System.out.println("입력된 idx : " + regRequest.getIdx());
		
		return String.valueOf(regRequest.getIdx());
	}

}
