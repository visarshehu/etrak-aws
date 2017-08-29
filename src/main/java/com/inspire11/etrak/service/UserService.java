package com.inspire11.etrak.service;

import com.inspire11.etrak.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}