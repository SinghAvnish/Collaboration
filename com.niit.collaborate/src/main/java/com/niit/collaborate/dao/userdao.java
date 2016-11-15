package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.User;

import java.util.List;


public interface UserDAO
{
public boolean save(User user);

public void Update(User user);

public void delete(int id);

public User get(int id);

public User getUsername(String username);

public List<User> list();

User authenticate(String username, String password);
}