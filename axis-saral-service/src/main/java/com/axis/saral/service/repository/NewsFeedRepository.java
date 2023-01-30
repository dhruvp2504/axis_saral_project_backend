package com.axis.saral.service.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axis.saral.service.entity.NewsFeed;



@Repository
public interface NewsFeedRepository extends CrudRepository<NewsFeed, Long> {

}
