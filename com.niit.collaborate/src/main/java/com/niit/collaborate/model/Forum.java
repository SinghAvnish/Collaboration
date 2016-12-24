package com.niit.collaborate.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Forum {

	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Id
	private int forumId;
	private int id;
	private String forumTitle;
	private String forumDescription;
	
	private Timestamp createdAt;
	
	private Timestamp modifiedAt;
    
	private char status;// 



public int getForumId() {
	return forumId;
}
public void setForumId(int forumId) {
	this.forumId = forumId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getForumTitle() {
	return forumTitle;
}
public void setForumTitle(String forumTitle) {
	this.forumTitle = forumTitle;
}
public String getForumDescription() {
	return forumDescription;
}
public void setForumDescription(String forumDescription) {
	this.forumDescription = forumDescription;
}
public Timestamp getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Timestamp createdAt) {
	this.createdAt = createdAt;
}
public Timestamp getModifiedAt() {
	return modifiedAt;
}
public void setModifiedAt(Timestamp modifiedAt) {
	this.modifiedAt = modifiedAt;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}
@Override
public String toString() {
	return "Forum [forumId=" + forumId + ", id=" + id + ", forumTitle=" + forumTitle + ", forumDescription="
			+ forumDescription + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", status=" + status + "]";
}



}
