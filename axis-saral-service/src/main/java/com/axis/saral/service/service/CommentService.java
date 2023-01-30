package com.axis.saral.service.service;

import java.util.List;

import com.axis.saral.service.entity.Comment;


public interface CommentService {

	List<Comment> getAllComments();
	Comment getCommentById(long commentId);
	void saveComment(Comment comment);
	void updateCommentDetails(long commentId, Comment updatedComment);
	void deleteCommentById(long commentId);
}
