package com.service.iface;

import java.util.List;

import com.entity.Comment;

public interface CommentServiceIface {
	
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
