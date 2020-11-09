package com.spring.biz.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		BoardVO vo = new BoardVO();
		
		//1. 게시글 목록 조회(SELECT)
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> list = boardDAO.getBoardList(vo);
		
		//2. 검색결과를 세션에 저장
		//request.getSession().setAttribute("boardList", list);
		
		//3. ModelAndView 형식으로 데이터 저장 및 뷰 이름 저장(화면 이동)
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", list);
		mav.setViewName("getBoardList"); //뷰리졸버 적용
		
		return mav;
	}

}






