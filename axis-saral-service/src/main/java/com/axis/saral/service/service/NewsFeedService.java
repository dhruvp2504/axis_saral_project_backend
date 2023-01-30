package com.axis.saral.service.service;

import java.util.List;

import com.axis.saral.service.entity.NewsFeed;


public interface NewsFeedService {
NewsFeed getNewsFeedById(long newsFeedId);
List<NewsFeed> getAllNewsFeeds();

void addNewsFeed(NewsFeed newsFeed);

void deleteNewsFeedById(long newsFeedId);

void updateNewsFeedById(long newsFeedId, NewsFeed updatedNewsFeed);
}
