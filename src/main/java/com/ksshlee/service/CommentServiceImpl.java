package com.ksshlee.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ksshlee.dao.CommentDAO;
import com.ksshlee.dto.*;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Inject
	private CommentDAO dao;
	
	
	
	
	//해당 게시글의 전체 댓글 출력
	@Override
	public List<CommentVO> allComment(int pid) throws Exception{
		return dao.allComment(pid);
	}
	

	//댓글 삭제
	@Override
	public void deleteComment(int cid) throws Exception{
		dao.deleteComment(cid);
	}
	
	//댓글 생성
	@Override
	public void createComment(CommentVO board) throws Exception{
		dao.createComment(board);
	}
	
	//대댓글 생성
	@Override
	public void createCommentOfComment(CommentVO board) throws Exception{
		dao.createCommentOfComment(board);
	}
	
	//댓글 수정
	@Override
	public void modifyComment(CommentVO board) throws Exception{
		dao.modifyComment(board);
	}
	

}
