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
public class BlogLike 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int blogLikeId;
	private int id; //user Id
	private int c_id; //blog id
	public int getBlogLikeId() {
		return blogLikeId;
	}
	public void setBlogLikeId(int blogLikeId) {
		this.blogLikeId = blogLikeId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	
	
}
