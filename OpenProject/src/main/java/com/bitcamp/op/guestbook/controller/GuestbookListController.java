package com.bitcamp.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.guestbook.domain.Pagination;
import com.bitcamp.op.guestbook.service.GuestBookListService;

@Controller
public class GuestbookListController {
	
	@Autowired
	private GuestBookListService listService;
	
	@RequestMapping("/guestbook/list")
	public void getGuestBookList(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			Model model
			) {
		
		model.addAttribute("listView", listService.getPage(pageNum));
				
	}

}
