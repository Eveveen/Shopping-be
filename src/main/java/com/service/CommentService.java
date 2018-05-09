package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.CommentMapper;
import com.entity.Comment;
import com.service.iface.CommentServiceIface;

@Service
public class CommentService implements CommentServiceIface {
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<Comment> findCommentByProId(Integer proId) {
		// TODO Auto-generated method stub
		return commentMapper.findCommentByProId(proId);
	}

	@Override
	public int addComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentMapper.addComment(comment);
	}

	@Override
	public int deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		return commentMapper.deleteComment(commentId);
	}

}
