package com.axis.saral.service.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.saral.service.entity.Comment;
import com.axis.saral.service.service.CommentService;

@CrossOrigin("http://localhost:3000")
@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@GetMapping("/comments")
	public List<Comment> getAllComments(){
		return commentService.getAllComments();
	}
	
	@GetMapping("/comment/{commentId}")
	public Comment commentById(@PathVariable long commentId) {
		return commentService.getCommentById(commentId);
	}
	
	@PostMapping("/comment")
	public ResponseEntity<String> addComment(@RequestBody Comment comment){
		commentService.saveComment(comment);
		return new ResponseEntity<String>("New Comment Added..!!", HttpStatus.OK);
	}
	
	@DeleteMapping("/comment/delete/{commentId}")
	public ResponseEntity<String> deleteCommentById(@PathVariable long commentId){
		commentService.deleteCommentById(commentId);
		return new ResponseEntity<String>("Comment Deleted ..!!", HttpStatus.OK);
	}
	
	@PutMapping("/comment/update/{commentId}")
	public ResponseEntity<String> updateCommentById(@PathVariable long commentId, @RequestBody Comment updatedComment){
		if(commentId != updatedComment.getCommentId()) {
			return new ResponseEntity<String>("Comment not Found..!!", HttpStatus.BAD_REQUEST);
		}else {
			commentService.updateCommentDetails(commentId, updatedComment);
			return new ResponseEntity<String>("Comment updated successfully..!!", HttpStatus.OK);
		}
	}
}
