package com.iris.daosimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.dao.RolesDao;
import com.iris.models.Roles;

@Component
@Repository(value="rolesDao")
@Transactional
public class RolesDaoImpl implements RolesDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Roles> getAllRole()
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query q = session.createQuery("from Roles");
			List<Roles> usersList=q.list();
			return usersList;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
}
