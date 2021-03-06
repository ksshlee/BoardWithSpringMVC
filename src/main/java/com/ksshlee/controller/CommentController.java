package com.ksshlee.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksshlee.dto.CommentVO;
import com.ksshlee.service.CommentService;

@Controller
public class CommentController {
	@Inject
	private CommentService cservice;
	
	
		// 댓글 생성
		@RequestMapping(value = "/createComment", method = RequestMethod.POST)
		public String newComment(@RequestParam("pid") int pid, CommentVO comment,HttpSession session) throws Exception {
			comment.setBid(pid);
			comment.setAuthor((String) session.getAttribute("sessionUserId"));
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
		public String newCommentOfComment(@RequestParam("pid") int pid, @RequestParam("cid") int cid, CommentVO comment,
				HttpSession session) throws Exception {
			comment.setBid(pid);
			comment.setRcid(cid);
			comment.setAuthor((String) session.getAttribute("sessionUserId"));
			cservice.createCommentOfComment(comment);
			return "redirect:read?pid=" + pid;
		}

		// 댓글 수정
		@RequestMapping(value = "/modifyComment", method = RequestMethod.POST)
		public String modifyComment(@RequestParam("pid") int pid, CommentVO comment) throws Exception {

			
			cservice.modifyComment(comment);

			return "redirect:read?pid=" + pid;
		}
	
	
	
}
