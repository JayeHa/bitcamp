package com.spring.biz.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		BoardVO board = boardDAO.getBoard(vo);
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println(">>> 게시글 전체 목록 보여주기 - getBoardList()");
		
		List<BoardVO> list = boardDAO.getBoardList(vo);
		//mav.addObject("boardList", list);
		//mav.setViewName("getBoardList.jsp");
		model.addAttribute("boardList", list);		
		return "getBoardList.jsp";
	}

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 입력 처리 - insertBoard()");
		boardDAO.insertBoard(vo);
		
		return "redirect:getBoardList.do";
	}	
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 수정 처리");
		
		boardDAO.updateBoard(vo);
		
		return "redirect:getBoardList.do";
	}	
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 삭제 처리");
		boardDAO.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}	
}
