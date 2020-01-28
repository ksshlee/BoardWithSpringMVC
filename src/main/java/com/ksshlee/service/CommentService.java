package com.ksshlee.service;

import java.util.List;

import com.ksshlee.dto.CommentVO;

public interface CommentService {
	public List<CommentVO> allComment(int pid) throws Exception;
	public void deleteComment(int cid) throws Exception;
	public void createComment(CommentVO board) throws Exception;
	public void createCommentOfComment(CommentVO board) throws Exception;
	public void modifyComment(CommentVO board) throws Exception;
}
