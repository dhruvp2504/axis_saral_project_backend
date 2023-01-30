package com.axis.saral.service.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.saral.service.entity.Comment;
import com.axis.saral.service.exception.CommentNotFoundException;
import com.axis.saral.service.repository.CommentRepository;


@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;

	@Override
	public List<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public Comment getCommentById(long commentId) {
		
		Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if ((!commentOptional.isPresent())) {
            throw new CommentNotFoundException("Comment not found with Id " + commentId);
        }
        return commentOptional.get();
	}

	@Override
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub
		commentRepository.save(comment);

	}

	@Transactional
	@Override
	public void updateCommentDetails(long commentId, Comment updatedComment) {
		// TODO Auto-generated method stub
		commentRepository.updateCommentInfo(updatedComment.getMessage(), updatedComment.getCommentedById(), 
				updatedComment.getCommentDate(), updatedComment.getFeedId(),
				updatedComment.getCommentId());
	}

	@Override
	public void deleteCommentById(long commentId) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(commentId);
	}
	
	
}
