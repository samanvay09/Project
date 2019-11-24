package com.iris.daosimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.dao.ProjectsDao;
import com.iris.models.Configuration;
import com.iris.models.ProjectAllocation;
import com.iris.models.Projects;


@Component
@Repository(value="projectsDao")
@Transactional
public class ProjectsDaoimpl implements ProjectsDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Projects> getAllProject()
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query q = session.createQuery("from Projects");
			List<Projects> projectList=q.list();
			return projectList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Configuration> getAllConfig()
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query q = session.createQuery("from Configuration");
			return q.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Projects getProjectById(int projectId)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Projects ca=session.get(Projects.class, projectId);
			return ca;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean setProjectConfig(Configuration pObj)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			 Query q=session.createQuery("from com.iris.models.Configuration where projectId=:projectId and roleId=:roleId and loc=:loc");
			 q.setParameter("projectId",pObj.getProjectId());
			   q.setParameter("roleId",pObj.getRoleId());
			   q.setParameter("loc",pObj.getLoc());
			   if(q.list().size()==0)
			   {
				   session.save(pObj);
					return true;
			   }
			
			//session.save(pObj);
			//return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Configuration> validateProject(int projectId,int roleId,String loc)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			 Query q=session.createQuery("from com.iris.models.Configuration where projectId.projectId=:projectId and roleId.roleId=:roleId and loc=:loc");
			 q.setParameter("projectId",projectId);
			   q.setParameter("roleId",roleId);
			   q.setParameter("loc",loc);
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public  boolean  setProjectAllocation(ProjectAllocation projectAllocation)
	{
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(projectAllocation);
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return false;
	
	}
	public List<ProjectAllocation> getAllProjectAllocation()
	{
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from ProjectAllocation");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}	
	
	
	public List<Configuration> getAllConfig(int projectId)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			 Query q=session.createQuery("from com.iris.models.Configuration where projectId=:projectId");
			 q.setParameter("projectId",projectId);
			 return q.list();
		}
		catch(Exception e)

		{

			e.printStackTrace();

		}

		return null;
	}
	
	}
