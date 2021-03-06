package com.iris.ProjectBillingBackend;

import static java.lang.System.out;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iris.config.DBConfig;
import com.iris.dao.UserDao;
import com.iris.models.Users;

/**
 * Hello world!
 *
 */
public class App 
{
	 private static UserDao userDaoObj;
	 @BeforeClass
		public static void init(){
			out.println("I m in init - start");
			//Created the object of Spring container
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
			
			
	   	 	userDaoObj=context.getBean(UserDao.class,"userDao");
	   	 	out.println("I m in init - end");
		}
	 
	 @Test
     public void validateUserTest(){
            Users r=userDaoObj.validateUser(5,"jain");
            assertNotNull("Employee not found", r);
     }
}
