package com.green.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.green.VO.BoardVO;
import com.green.VO.ConditionValue;
import com.green.entity.Board;
import com.green.repository.BoardRepository;

@Service
public class BoardServiceImpe implements BoardService {

	@Autowired
	BoardRepository br;
	
	@Override
	public List<BoardVO> getMainVrList() {
		
		Sort sort = Sort.by("regDate").descending();		
		Pageable pageable = PageRequest.of(0, 3, sort);		
		Page<Board> result = br.getBoardPage(2, pageable);		
		List<BoardVO> list = new ArrayList<>();
		
		
		
		for(Board board : result.getContent()) {
			
			BoardVO boardVO = new BoardVO();
			
			boardVO.setBoardNo(board.getBoardNo());
			boardVO.setBoardTitle(board.getBoardTitle());
			boardVO.setBoardContent(board.getBoardContent());
			boardVO.setBoardWriteYear(board.getRegDate().getYear());
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());
			boardVO.setBoardFile(board.getBoardFile());			
			list.add(boardVO);			
		}
		return list;		
	}

	@Override
	public List<BoardVO> getMainVideoList() {
		
		Sort sort = Sort.by("regDate").descending();
		
		Pageable pageable = PageRequest.of(0, 3, sort);
		
		Page<Board> result = br.getBoardPage(3, pageable);
		
		List<BoardVO> list = new ArrayList<>();
		
		for(Board board : result.getContent()) {
			
			BoardVO boardVO = new BoardVO();			
			boardVO.setBoardNo(board.getBoardNo());
			boardVO.setBoardTitle(board.getBoardTitle());
			boardVO.setBoardContent(board.getBoardContent());
			boardVO.setBoardFile(board.getBoardFile());
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());
			list.add(boardVO);			
		}
		return list;		
	}

	@Override
	public List<BoardVO> getVrList(ConditionValue cv) {
		
		Sort sort = Sort.by("regDate").descending();		
		Pageable pageable = PageRequest.of(cv.getPageNum()-1, 9, sort);		
		Page<Board> result = br.getBoardPage(2, pageable);		
		List<BoardVO> list = new ArrayList<>();
		
		for(Board board : result.getContent()) {			
			BoardVO boardVO = new BoardVO();			
			boardVO.setBoardNo(board.getBoardNo());
			boardVO.setBoardTitle(board.getBoardTitle());
			boardVO.setBoardContent(board.getBoardContent());
			boardVO.setBoardWriteYear(board.getBoardWriteYear());
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());
			boardVO.setBoardFile(board.getBoardFile());
			list.add(boardVO);			
		}
		return list;		
	}

	@Override
	public List<BoardVO> getVideoList(ConditionValue cv) {
		
		Sort sort = Sort.by("regDate").descending();		
		
		Pageable pageable = PageRequest.of(cv.getPageNum()-1, 9, sort);		
		Page<Board> result = br.getBoardPage(3, pageable);		
		List<BoardVO> list = new ArrayList<>();		
		
		for(Board board : result.getContent()) {			
			BoardVO boardVO = new BoardVO();			
			boardVO.setBoardNo(board.getBoardNo());
			boardVO.setBoardTitle(board.getBoardTitle());
			boardVO.setBoardContent(board.getBoardContent());
			boardVO.setBoardFile(board.getBoardFile());
			boardVO.setRegDate(board.getRegDate());
			boardVO.setModDate(board.getModDate());			
			list.add(boardVO);			
		}		
		return list;		
	}

	@Override
	public int getVrCount() {
		
		Pageable pageable = PageRequest.of(0, 9);
		
		Page<Board> result = br.getBoardPage(2, pageable);
		
		return (int)result.getTotalElements();
		
	}

	@Override
	public int getVideoCount() {
		
		Pageable pageable = PageRequest.of(0, 9);
		
		Page<Board> result = br.getBoardPage(3, pageable);
		
		return (int)result.getTotalElements();
		
	}

	
	
	
}
