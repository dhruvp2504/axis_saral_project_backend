package com.axis.saral.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.saral.service.entity.NewsFeed;
import com.axis.saral.service.exception.NewsFeedNotFoundException;
import com.axis.saral.service.repository.NewsFeedRepository;


@Service
public class NewsFeedServiceImpl implements NewsFeedService{

	@Autowired
	NewsFeedRepository newsFeedRepository;
	
	@Override
	public NewsFeed getNewsFeedById(long newsFeedId) {
		Optional<NewsFeed> newsFeedOptional = newsFeedRepository.findById(newsFeedId);
		
		if(!newsFeedOptional.isPresent()) {
			throw new NewsFeedNotFoundException("News Feed Not Found with ID: " +newsFeedId);
		}
		return newsFeedOptional.get();
	}

	@Override
	public List<NewsFeed> getAllNewsFeeds() {
		// TODO Auto-generated method stub
		return (List<NewsFeed>) newsFeedRepository.findAll();
	}

	@Override
	public void addNewsFeed(NewsFeed newsFeed) {
		// TODO Auto-generated method stub
		newsFeedRepository.save(newsFeed);
	}

	@Override
	public void deleteNewsFeedById(long newsFeedId) {
		// TODO Auto-generated method stub
		newsFeedRepository.deleteById(newsFeedId);
	}

	@Override
	public void updateNewsFeedById(long newsFeedId, NewsFeed updatedNewsFeed) {
		// TODO Auto-generated method stub
		newsFeedRepository.save(updatedNewsFeed);
	}

}
