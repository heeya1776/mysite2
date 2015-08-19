package com.bit2015.mysite2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.mysite2.service.GuestBookService;
import com.bit2015.mysite2.vo.GuestBookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@Autowired
	GuestBookService guestBookService;
	
	@RequestMapping("/list")
	public String guestBookList(Model model){
		
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();
		list = guestBookService.list();
		
		model.addAttribute("list", list);
		
		return "guestbook/list";
	}
	
	@RequestMapping("/insert")
	public String guestBookInsert(@ModelAttribute GuestBookVo vo){
		
		guestBookService.insert(vo);
		
		return "redirect:/guestbook/list";
	}
	
	@RequestMapping("/deleteform")
	public String guestBookDeleteForm(){
		
		return "guestbook/deleteform";
		
	}
	
	@RequestMapping("/delete/{no}")
	public String guestBookDelete(@PathVariable long no, @ModelAttribute GuestBookVo vo){
	
		guestBookService.delete(no, vo.getPassword());
		
		return "redirect:/guestbook/list";
	}

}
