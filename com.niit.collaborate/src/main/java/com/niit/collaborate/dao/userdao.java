package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.User;

import java.util.List;


public interface userdao
{
public boolean save(User user);

public void Update(User user);

public void delete(int userId);

public User get(int userId);

public List<User> list();

}