package com.iris.dao;

import com.iris.models.Users;

public interface UserDao {
	
	public Users validateUser(int userId,String password);

}
