package com.dao;

import com.domain.User;

public interface LoginDao {
	
	boolean authenticateUser(String userName, String password);
	
	void save(User user);

}
