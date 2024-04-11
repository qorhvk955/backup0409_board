package com.green.service;

import java.util.List;

import com.green.VO.BoardVO;
import com.green.VO.ConditionValue;

public interface BoardService {
	
	public List<BoardVO> getMainVrList();
	public List<BoardVO> getMainVideoList();

	public List<BoardVO> getVrList(ConditionValue cv);
	public List<BoardVO> getVideoList(ConditionValue cv);
	
	public int getVrCount();
	public int getVideoCount();
	
	
}
