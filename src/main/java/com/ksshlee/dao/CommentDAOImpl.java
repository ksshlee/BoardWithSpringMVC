package com.ksshlee.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ksshlee.dto.CommentVO;

@Repository
public class CommentDAOImpl implements CommentDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.ksshlee.study.mappers.commentMapper";
	
	
	
	//게시글의 댓글 조회
	@Override
	public List<CommentVO> allComment(int pid) throws Exception{
		return sqlSession.selectList(Namespace+".allComment",pid);
	}
	

	
	//댓글 삭제
	@Override
	public void deleteComment(int cid) throws Exception{
		sqlSession.delete(Namespace+".deleteComment",cid);
	}
	
	//댓글 작성
	@Override
	public void createComment(CommentVO board) throws Exception{
		sqlSession.insert(Namespace+".createComment",board);
	}
	
	//대댓글 작성
	@Override
	public void createCommentOfComment(CommentVO board) throws Exception{
		sqlSession.insert(Namespace+".createCommentOfComment",board);
	}
	
	//댓글 수정
	@Override
	public void modifyComment(CommentVO board) throws Exception{
		sqlSession.update(Namespace+".modifyComment",board);
	}
	
	
	
}
