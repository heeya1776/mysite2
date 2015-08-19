package com.bit2015.mysite2.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite2.dao.GuestBookDao;
import com.bit2015.mysite2.vo.GuestBookVo;

@Service
public class GuestBookService {
	
	@Autowired
	GuestBookDao guestBookDao;
	
	public List<GuestBookVo> list(){
		
		List<GuestBookVo> list = guestBookDao.getList();
		
		return list;
		
	}
	
	public void insert(GuestBookVo vo){
		guestBookDao.add(vo);
	}
	
	public void delete(long no, String password){
		
		guestBookDao.delete(no, password);
	}

}
