package com.niit.collaborate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="c_User")

public class User 
{
	
@Id
private int userId;

private String name;

private String Email;

private String Password;

private String Address;

public int getUserId() 
{
	return userId;
}

public void setUserId(int userId) 
{
	this.userId = userId;
}

public String getName()
{
	return name;
}

public void setName(String name)
{
	this.name = name;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", name=" + name + ", Email=" + Email + ", Password=" + Password + ", Address="
			+ Address + "]";
}




}
