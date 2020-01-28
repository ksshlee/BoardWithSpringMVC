package com.ksshlee.service;

import java.util.List;
import com.ksshlee.dto.*;


public interface BoardService {
	public List<BoardVO> allBoard() throws Exception;
	public BoardVO readBoard(int pid) throws Exception;
	public void deleteBoard(int pid) throws Exception;
	public void createBoard(BoardVO board) throws Exception;
	public void modifyBoard(BoardVO board) throws Exception;
	
}
