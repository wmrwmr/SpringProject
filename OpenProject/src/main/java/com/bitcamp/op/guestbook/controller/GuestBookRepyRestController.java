package com.bitcamp.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.op.guestbook.domain.ReplyRegRequest;
import com.bitcamp.op.guestbook.service.ReplyDeleteService;
import com.bitcamp.op.guestbook.service.ReplyRegService;

@RestController
@RequestMapping("/api/v1/guestbook/reply")
public class GuestBookRepyRestController {

	@Autowired
	private ReplyRegService regService;
	
	@Autowired
	private ReplyDeleteService deleteService;

	// 댓글 입력
	@PostMapping
	public String regReply(ReplyRegRequest regRequest) {
		
		regService.insertReply(regRequest);
		System.out.println("입력된 idx : " + regRequest.getIdx());
		return String.valueOf(regRequest.getIdx());
	}

	// 댓글 삭제
	@DeleteMapping("/{idx}")
	public String deleteReply( 
			//@RequestParam("idx") int idx
			@PathVariable("idx") int idx
			) {
		
		System.out.println("idx 확인 " + idx);
		
		
		return String.valueOf(deleteService.deleteReply(idx));
	}

}
