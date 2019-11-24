package com.iris.services;

import com.iris.models.Users;

public interface UsersService {
	
	public Users validateUser(int userId,String password);

}
