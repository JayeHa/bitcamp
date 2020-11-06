package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL문
	private final String BOARD_INSERT
		= "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT) "
		+ "VALUES ((SELECT NVL(MAX(SEQ),0) + 1 FROM BOARD) , ?, ?, ?)";
	private final String BOARD_UPDATE
		= "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";
	private final String BOARD_DELETE
		= "DELETE FROM BOARD WHERE SEQ = ?";
	private final String BOARD_GET
		= "SELECT * FROM BOARD WHERE SEQ = ?";
	private final String BOARD_LIST
		= "SELECT * FROM BOARD ORDER BY SEQ DESC";	
	
	public BoardDAOSpring() {
		System.out.println(">> BoardDAOSpring() 객체 생성");
	}
	
	//글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 실행");
		
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(BOARD_INSERT, args);
	};
	
	//글 수정
	public void updateBoard(BoardVO vo) {
		
	};
	
	//글 삭제
	public void deleteBoard(BoardVO vo) {
		
	};
	
	//글 조회(하나만)
	public BoardVO getBoard(BoardVO vo) {
		return vo;
		
	};
	
	//글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> Spring JDBC로 getBoardList() 실행");
		return null;
		
	};
}
