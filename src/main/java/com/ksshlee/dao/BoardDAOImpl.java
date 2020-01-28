package com.ksshlee.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ksshlee.dto.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.ksshlee.study.mappers.boardMapper";

	
	// 전체 게시글 출력	
	@Override
	public List<BoardVO> allBoard() throws Exception{
		return sqlSession.selectList(Namespace+".allBoard");
	}
	
	// 해당 게시글만 조회
	@Override
	public BoardVO readBoard(int pid) throws Exception{
		return sqlSession.selectOne(Namespace+".readBoard",pid);
	}
	
	
	
	// 게시글 삭제
	@Override
	public void deleteBoard(int pid) throws Exception{
		sqlSession.delete(Namespace+".deleteBoard", pid);
	}
	
	// 새로운 게시글
	public void createBoard(BoardVO board) throws Exception{
		sqlSession.insert(Namespace+".createBoard", board);
	}
	
	// 게시글 수정
	public void modifyBoard(BoardVO board) throws Exception{
		sqlSession.update(Namespace+".modifyBoard", board);
	}
	
	
}
