package com.bit2015.mysite2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.mysite2.service.BoardService;
import com.bit2015.mysite2.vo.BoardVo;
import com.bit2015.mysite2.vo.UserVo;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/list")
	public String BoardList(@RequestParam(required=false, defaultValue="1") long pageNo, Model model) {
		
		System.out.println(pageNo);
		long totcnt = boardService.getTotal();
		List<BoardVo> list = boardService.list(pageNo);
		long beginPageListNo = (pageNo/5*5)+1;
		long endPageListNo = (pageNo/5*5)+5;
		if(endPageListNo>=totcnt/5+1){
			endPageListNo = totcnt/5+1;
		}
		long jumpPageListLeft = pageNo-1;
		if(jumpPageListLeft<1){
			jumpPageListLeft = 1;
		}
		long jumpPageListRight = pageNo+1;
		if(jumpPageListRight>=totcnt/5+1){
			jumpPageListRight = totcnt/5+1;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageCount", totcnt/5+1);
		model.addAttribute("beginPageListNo", beginPageListNo);
		model.addAttribute("endPageListNo", endPageListNo);
		model.addAttribute("jumpPageListLeft", jumpPageListLeft);
		model.addAttribute("jumpPageListRight", jumpPageListRight);
		
		return "board/list";
		
	}
	
	@RequestMapping("/write")
	public String BoardWrite(){
		
		return "board/write";
		
	}
	
	@RequestMapping("/add")
	public String BoardAdd(HttpSession session, @ModelAttribute BoardVo boardVo ){
	
		UserVo vo = (UserVo)session.getAttribute("authUser");
		if(vo == null){
			return "user/login";
		}
		
		boardVo.setName(vo.getName());
		boardVo.setMemberNo(vo.getNo());
		
		boardService.insert(boardVo);
		
		
		return "redirect:/board/list";
		
	}
	
	@RequestMapping("/addReply/{no}")
	public String BoardAddReply(HttpSession session, @ModelAttribute BoardVo boardVo, @PathVariable long no ){
		
		UserVo vo = (UserVo)session.getAttribute("authUser");
		if(vo == null){
			return "user/login";
		}
		
		BoardVo replyVo = boardService.getVo(no);
		
		
		System.out.println(replyVo);
		boardVo.setGroupNo(replyVo.getGroupNo());
		boardVo.setOrderNo(replyVo.getOrderNo());
		boardVo.setDepth(replyVo.getDepth());
		
		boardVo.setName(vo.getName());
		boardVo.setMemberNo(vo.getNo());
		
		boardService.updateReply(boardVo);
		boardService.insertReply(boardVo);
		
		
	
		return "redirect:/board/list";
		
	}
	
	@RequestMapping("/delete/{no}")
	public String BoardDelete(@PathVariable long no){
		
		boardService.delete(no);
		return "redirect:/board/list";
		
	}
	
	@RequestMapping("/search")
	public String BoardSearch(@RequestParam(value="kwd", required=false) String kwd, Model model){
		
		List<BoardVo> list = boardService.list2(kwd);
		
		model.addAttribute("list", list);
		
		return "/board/list";
		
	}
	
	@RequestMapping("/viewform/{no}")
	public String BoardViewForm(@PathVariable long no, Model model){
	
		BoardVo vo = boardService.getVo(no);
		boardService.update(no);
		model.addAttribute("writer", vo);
		
		return "board/view";
	}
	
	@RequestMapping("/modifyform/{no}")
	public String BoardModifyForm(@PathVariable long no, Model model){
		
		BoardVo vo = boardService.getVo(no);
		model.addAttribute("userVo", vo);
		
		return "board/modify";
	}
	
	@RequestMapping("/modify/{no}")
	public String BoardModify(@PathVariable long no, @ModelAttribute BoardVo vo){
		
		boardService.update(vo);
		
		return "redirect:/board/list";
		
	}

	@RequestMapping("/replyform")
	public String BoardReply(){
		return "board/reply";
	}
	
}
