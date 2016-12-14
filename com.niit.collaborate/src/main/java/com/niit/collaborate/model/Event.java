package com.niit.collaborate.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "C_EVENT")
public class Event {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String venue;
	private String description;
	@Column(name="date_time")
	private String dateTime;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", venue=" + venue + ", description=" + description
				+ ", dateTime=" + dateTime + "]";
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
