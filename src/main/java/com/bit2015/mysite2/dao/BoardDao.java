package com.bit2015.mysite2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.bit2015.mysite2.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public List<BoardVo> getList(long pageNo){
		
		List<BoardVo> list = sqlMapClientTemplate.queryForList("board.getList", pageNo);
		
		return list;
		
	}
	
	public List<BoardVo> getList2(String kwd){
		
		List<BoardVo> list = sqlMapClientTemplate.queryForList("board.getList2", kwd);
		
		return list;
	}
	
	public void insert(BoardVo vo){
		
		sqlMapClientTemplate.insert("board.insert", vo);
		
	}
	
	public void insertReply(BoardVo vo){
		
		sqlMapClientTemplate.insert("board.insertReply", vo);
		
	}

	public void delete(long no){
		
		sqlMapClientTemplate.delete("board.delete", no);
		
	}
	
	public BoardVo getVo(long no){
		
		BoardVo vo = (BoardVo)sqlMapClientTemplate.queryForObject("board.getVo", no);
		
		return vo;
	}
	
	public void update(BoardVo vo){
		
		sqlMapClientTemplate.update("board.update", vo);
		
	}
	
	public void update(long no){
		
		sqlMapClientTemplate.update("board.update2", no);
		
	}
	
	public void updateReply(BoardVo vo){
		
		sqlMapClientTemplate.update("board.updateReply", vo);
		
	}
}
