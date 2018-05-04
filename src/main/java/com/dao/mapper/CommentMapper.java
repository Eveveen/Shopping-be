package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Comment;

@Repository
public interface CommentMapper {
	
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
