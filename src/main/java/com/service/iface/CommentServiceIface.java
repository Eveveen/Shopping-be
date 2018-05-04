package com.service.iface;

import java.util.List;

import com.entity.Comment;

public interface CommentServiceIface {
	
	/**
	 * 查询该商品的所有评价
	 * @param proId
	 * @return
	 */
	public List<Comment> findCommentByProId(Integer proId);
	
	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	public int addComment(Comment comment);
	
	/**
	 * 删除评论
	 * @param commentId
	 * @return
	 */
	public int deleteComment(Integer commentId);

}
