package com.bitcamp.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.guestbook.service.GuestBookPageViewService;
import com.bitcamp.op.guestbook.service.ReplyListService;

@Controller
public class GuestBookViewController {
	
	@Autowired
	private GuestBookPageViewService viewService;
	
	@Autowired
	private ReplyListService replyListService;
	

	@GetMapping("/guestbook/view")
	public void getViewPage(
			@RequestParam("idx") int idx,
			Model model
			) {
		model.addAttribute("pageView", viewService.getPageView(idx));
		model.addAttribute("replyList", replyListService.getList(idx));
	}
	
}
