package com.spring.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController {
	
	@RequestMapping("/getBoard")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println(">>게시글 보여주기 - getBoard()");
		
		BoardVO board = boardDAO.getBoard(vo);

		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}
/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(">>> 게시글 상세보기");
		//1. 전달받은 파라미터 확인
		String seq = request.getParameter("seq");
		
		//2. DB연동처리(글 하나 조회)
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		//3. ModelAndView 에 데이터, 뷰이름 저장 후 응답처리(페이지 전환)
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}
*/
}









