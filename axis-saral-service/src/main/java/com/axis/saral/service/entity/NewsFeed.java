package com.axis.saral.service.entity;

import java.util.Date;


import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class NewsFeed {

	@Id
	@GeneratedValue
	private long newsFeedId;
	private String newsTitle;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date newsUploadDate;
	private String newsContent;
	
	public NewsFeed() {
		
	}

	
	public NewsFeed(long newsFeedId, String newsTitle, Date newsUploadDate, String newsContent) {
		super();
		this.newsFeedId = newsFeedId;
		this.newsTitle = newsTitle;
		this.newsUploadDate = newsUploadDate;
		this.newsContent = newsContent;
	}

	public long getNewsFeedId() {
		return newsFeedId;
	}

	public void setNewsFeedId(long newsFeedId) {
		this.newsFeedId = newsFeedId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public Date getNewsUploadDate() {
		return newsUploadDate;
	}

	public void setNewsUploadDate(Date newsUploadDate) {
		this.newsUploadDate = newsUploadDate;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	@Override
	public int hashCode() {
		return Objects.hash(newsFeedId, newsTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewsFeed other = (NewsFeed) obj;
		return newsFeedId == other.newsFeedId && Objects.equals(newsTitle, other.newsTitle);
	}

	@Override
	public String toString() {
		return "NewsFeed [newsFeedId=" + newsFeedId + ", newsTitle=" + newsTitle + ", newsUploadDate=" + newsUploadDate
				+ ", newsContent=" + newsContent + "]";
	}
	
}
