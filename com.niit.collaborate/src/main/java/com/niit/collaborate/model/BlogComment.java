package com.niit.collaborate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class BlogComment extends BaseDomain{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int blogCommentId;
	private int id; //user id
	private String blogCommentContent;
	private int c_id; //blog id
	private Date dateTime;
	private String rating;
	
	
	
	
	
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBlogCommentId() {
		return blogCommentId;
	}
	public void setBlogCommentId(int blogCommentId) {
		this.blogCommentId = blogCommentId;
	}
	public String getBlogCommentContent() {
		return blogCommentContent;
	}
	public void setBlogCommentContent(String blogCommentContent) {
		this.blogCommentContent = blogCommentContent;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	
}
