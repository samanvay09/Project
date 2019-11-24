package com.iris.daosimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.dao.UserDao;
import com.iris.models.Users;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;	
	
	@Transactional
	public Users validateUser(int userId, String password) {
		try {
		Session session=sessionFactory.getCurrentSession();
		Users userObj=session.get(Users.class, userId);
		
		
		if(userObj!=null){
			if(userObj.getPassword().equals(password)){
				return userObj;
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
