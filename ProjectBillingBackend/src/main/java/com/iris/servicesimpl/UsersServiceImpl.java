package com.iris.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.dao.UserDao;
import com.iris.models.Users;
import com.iris.services.UsersService;

@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UserDao userDao;
	
	public Users validateUser(int userId,String password)
	{
		return userDao.validateUser(userId, password);
	}

}
