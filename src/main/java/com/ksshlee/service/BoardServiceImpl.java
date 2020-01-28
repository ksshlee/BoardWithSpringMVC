package com.ksshlee.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ksshlee.dao.BoardDAO;
import com.ksshlee.dto.*;


@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	
	//게시글 전체 출력 
	@Override
	public List<BoardVO> allBoard() throws Exception{
		return dao.allBoard();
	}
	
	// 해당 게시글만 조회
	@Override
	public BoardVO readBoard(int pid) throws Exception{
		return dao.readBoard(pid);
	}
	
	
	//게시글 삭제
	@Override
	public void deleteBoard(int pid) throws Exception{
		dao.deleteBoard(pid);
	}
	
	
	//게시글 생성
	@Override
	public void createBoard(BoardVO board) throws Exception{
		dao.createBoard(board);
	}
	
	
	//게시글 수정
	@Override
	public void modifyBoard(BoardVO board) throws Exception{
		dao.modifyBoard(board);
	}
	
	
}
