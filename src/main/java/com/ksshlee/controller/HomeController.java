package com.ksshlee.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksshlee.dto.BoardVO;
import com.ksshlee.dto.CommentVO;
import com.ksshlee.service.BoardService;
import com.ksshlee.service.CommentService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private BoardService service;
	@Inject
	private CommentService cservice;

	// 메인 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String boardHome(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		List<BoardVO> boardList = service.allBoard();

		model.addAttribute("boardList", boardList);

		return "boardHome";
	}

	// 글 쓰기 GET
	@RequestMapping(value = "/newBoard", method = RequestMethod.GET)
	public String newBoardGet() throws Exception {
		return "newBoard";
	}

	// 글 쓰기 POST
	@RequestMapping(value = "/newBoard", method = RequestMethod.POST)
	public String newBoardPost(BoardVO board) throws Exception {
		service.createBoard(board);
		return "redirect:/";
	}

	// 글 읽기
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String readBoard(@RequestParam("pid") int pid, Model model) throws Exception {

		model.addAttribute("boardVO", service.readBoard(pid));

		// 해당 게시물에 있는 댓글
		List<CommentVO> commentList = cservice.allComment(pid);

		model.addAttribute("CommentList", commentList);

		return "readBoard";
	}

	// 글 수정 GET
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyBoardGet(@RequestParam("pid") int pid, Model model) throws Exception {
		model.addAttribute("boardVO", service.readBoard(pid));

		return "modifyBoard";
	}

	// 글 수정 POST
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyBoardPost(@RequestParam("pid") int pid, BoardVO board) throws Exception {

		service.modifyBoard(board);

		return "redirect:read?pid=" + pid;
	}

	// 글 삭제
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String delete(@RequestParam("pid") int pid) throws Exception {
		service.deleteBoard(pid);
		return "redirect:/";
	}

	// 댓글 생성
	@RequestMapping(value = "/createComment", method = RequestMethod.POST)
	public String newComment(@RequestParam("pid") int pid, CommentVO comment) throws Exception {
		comment.setBid(pid);
		cservice.createComment(comment);
		return "redirect:read?pid=" + pid;
	}

	// 댓글 삭제
	@RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
	public String deleteComment(@RequestParam("cid") int cid, @RequestParam("pid") int pid) throws Exception {
		cservice.deleteComment(cid);
		return "redirect:read?pid=" + pid;
	}

	// 댓글 답글 생성
	@RequestMapping(value = "/createCommentOfComment", method = RequestMethod.POST)
	public String newCommentOfComment(@RequestParam("pid") int pid, @RequestParam("cid") int cid, CommentVO comment)
			throws Exception {
		comment.setBid(pid);
		comment.setRcid(cid);
		cservice.createCommentOfComment(comment);
		return "redirect:read?pid=" + pid;
	}

	// 댓글 수정
	@RequestMapping(value = "/modifyComment", method = RequestMethod.POST)
	public String modifyComment(@RequestParam("pid") int pid, CommentVO comment) throws Exception {

		System.out.println(comment.getAuthor());
		System.out.println(comment.getContent());
		System.out.println(comment.getPwd());
		System.out.println(comment.getCid());
		System.out.println(comment.getRcid());
		
		cservice.modifyComment(comment);

		return "redirect:read?pid=" + pid;
	}

}
