package com.bit2015.mysite2.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite2.dao.UserDao;
import com.bit2015.mysite2.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public void join(UserVo userVo){
		
		userDao.insert(userVo);
		
	}
	
	public UserVo login(UserVo userVo){
		UserVo vo = userDao.get(userVo.getEmail(), userVo.getPassword());
		return vo;
	}
	
	public UserVo getVo(String email){
		
		UserVo vo = userDao.getVo(email);
		
		return vo;
	}
	
}
