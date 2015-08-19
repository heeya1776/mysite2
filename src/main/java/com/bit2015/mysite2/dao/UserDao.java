package com.bit2015.mysite2.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite2.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public UserVo get(String email, String password){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		
		UserVo vo = (UserVo)sqlMapClientTemplate.queryForObject("user.getbyemailandpassword", map);
		
		return vo;
		
	}
	
	public void insert(UserVo vo){
		
		sqlMapClientTemplate.insert("user.insert", vo);
			
	}
	
	public UserVo getVo(String email){
		
		UserVo vo = (UserVo)sqlMapClientTemplate.queryForObject("user.getVo", email);
		return vo;
		
	}

}
