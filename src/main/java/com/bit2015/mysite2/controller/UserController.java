package com.bit2015.mysite2.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.mysite2.service.UserService;
import com.bit2015.mysite2.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform(){
		return "user/joinform";
	}
	
	@RequestMapping("/join")
	public String join(UserVo userVo){
		
		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinsuccess(){
		
		return "user/joinsuccess";
	}
	
	@RequestMapping("/loginform")
	public String loginform(){
		
		return "user/loginform";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, @ModelAttribute UserVo userVo){
		
		UserVo vo = userService.login(userVo);
		
		if(vo == null){
			return "redirect:/user/loginform";
		}
		
		session.setAttribute("authUser", vo);
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		
		if(session == null){
			return "redirect:/";
		}
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping("/checkemail")
	@ResponseBody
	public Object checkEmail(String email){
		
		UserVo vo = userService.getVo(email);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", (vo == null)?"not exist":"exist");
		
		return map;
	}
	
}
