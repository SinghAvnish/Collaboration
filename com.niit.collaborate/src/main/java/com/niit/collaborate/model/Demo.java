package com.niit.collaborate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Demo {

@Id
  private int DemoId;

	private String name;
	
	public int getDemoId() {
		return DemoId;
	}

	public void setDemoId(int demoId) {
		DemoId = demoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	private String  Address;
	

}
