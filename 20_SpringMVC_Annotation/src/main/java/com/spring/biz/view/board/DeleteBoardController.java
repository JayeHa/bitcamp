package com.spring.biz.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(">>> 게시글 삭제 처리");
		//1. 전달받은 파라미터 추출(확인)
		String seq = request.getParameter("seq");
		
		//2. DB연동 처리(데이터 삭제)
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		System.out.println("vo : " + vo);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		//3. 화면네비게이션(목록페이지로 이동)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		
		return mav;
	}
	*/

}
