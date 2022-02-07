package com.bitcamp.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.op.guestbook.service.ReplyDeleteService;

@Controller
public class GuestBookReplyDeleteController {
	
	@Autowired
	private ReplyDeleteService deleteService;
	
	@RequestMapping("/guestbook/reply/delete")
	@ResponseBody
	public String deleteReply( @RequestParam("idx") int idx ) {
		return String.valueOf(deleteService.deleteReply(idx));
	}

}
