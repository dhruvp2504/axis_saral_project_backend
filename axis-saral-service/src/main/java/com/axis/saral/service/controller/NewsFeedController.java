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

import com.axis.saral.service.entity.NewsFeed;
import com.axis.saral.service.service.NewsFeedService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")

public class NewsFeedController {

	@Autowired
	NewsFeedService newsFeedService;
	
	@GetMapping("/newsfeeds")
	public List<NewsFeed> getAllNewsFeeds(){
		return newsFeedService.getAllNewsFeeds();
	}
	
	@GetMapping("/newsfeed/{newsFeedId}")
	public NewsFeed getNewsFeedByID(@PathVariable long newsFeedId) {
		return newsFeedService.getNewsFeedById(newsFeedId);
	}
	
	@PostMapping("/newsfeed")
	public ResponseEntity<String> addNewsFeed(@RequestBody NewsFeed newsFeed){
		newsFeedService.addNewsFeed(newsFeed);
		return new ResponseEntity<String>("New NewsFeed Added Successfully..", HttpStatus.OK);
	}
	
	@DeleteMapping("/newsfeed/delete/{newsFeedId}")
	public ResponseEntity<String> deleteNewsFeedById(@PathVariable long newsFeedId){
		newsFeedService.deleteNewsFeedById(newsFeedId);
		return new ResponseEntity<String>("Required NewsFeed Deleted", HttpStatus.OK);
	}
	
	@PutMapping("/newsfeed/update/{newsFeedId}")
	public ResponseEntity<String> updateNewsFeedById(@PathVariable long newsFeedId, @RequestBody NewsFeed updatedNewsFeed){
		if(newsFeedId == updatedNewsFeed.getNewsFeedId()) {
			newsFeedService.updateNewsFeedById(newsFeedId, updatedNewsFeed);
			return new ResponseEntity<String>("NewsFeed Updated Successfully..!!", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("NewsFeed with provided ID not found", HttpStatus.BAD_REQUEST);
		}
	}
}
