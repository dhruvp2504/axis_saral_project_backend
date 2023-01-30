package com.axis.saral.service.repository;

import java.util.Date;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axis.saral.service.entity.Comment;


@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

	@Modifying
	@Query("update Comment set message=?1, commentedById=?2, commentDate=?3, feedId=?4 where commentId=?4")
	public void updateCommentInfo(String message, String commentedById, Date commentDate, long feedId, long commentId);
}
