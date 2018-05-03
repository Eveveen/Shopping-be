package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Comment;
import com.service.iface.CommentServiceIface;

@Controller
public class CommentController {
	
	private CommentServiceIface commentService;
	
	/**
	 * ��ȡ����Ʒ����������
	 * @param proId
	 * @return
	 */
	@RequestMapping("/getAllComment")
	@ResponseBody
	public List<Comment> findCommentByProId(Integer proId){
		return commentService.findCommentByProId(proId);
	}
	
	/**
	 * �������
	 * @param comment
	 * @return
	 */
	@RequestMapping("/addComment")
	@ResponseBody
	public boolean addComment(Comment comment){
		if(commentService.addComment(comment) == 1) {
			return true;
		} else {			
			return false;
		}
	}

}
