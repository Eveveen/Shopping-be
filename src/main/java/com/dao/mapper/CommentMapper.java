package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Comment;

@Repository
public interface CommentMapper {
	
	/**
	 * ��ѯ����Ʒ����������
	 * @param proId
	 * @return
	 */
	public List<Comment> findCommentByProId(Integer proId);
	
	/**
	 * �������
	 * @param comment
	 * @return
	 */
	public int addComment(Comment comment);
	
	/**
	 * ɾ������
	 * @param commentId
	 * @return
	 */
	public int deleteComment(Integer commentId);

}
