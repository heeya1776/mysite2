package com.bit2015.mysite2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.mysite2.dao.BoardDao;
import com.bit2015.mysite2.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	BoardDao boardDao;

	public List<BoardVo> list(long pageNo){
		
		List<BoardVo> list = boardDao.getList(pageNo);
		
		return list;
	}
	
	public List<BoardVo> list2(String kwd){
		
		List<BoardVo> list = boardDao.getList2(kwd);
		
		return list;
	}
	
	public void insert(BoardVo vo){
		
		boardDao.insert(vo);
		
	}
	
	public void delete(long no){
		
		boardDao.delete(no);
		
	}
	
	public BoardVo getVo(long no){
		
		BoardVo vo = boardDao.getVo(no);
		
		return vo;
	}
	
	public void update(BoardVo vo){
		
		boardDao.update(vo);
		
	}
	
	public void update(long no){
		
		boardDao.update(no);
		
	}
	
	public void insertReply(BoardVo vo){
		
		boardDao.insertReply(vo);
		
	}
	
	public void updateReply(BoardVo vo){
		
		vo.setOrderNo(vo.getOrderNo()+1);
		vo.setDepth(vo.getDepth()+1);
		boardDao.updateReply(vo);
		
	}
	
}
