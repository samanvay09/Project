package com.iris.ProjectBillingBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iris.config.DBConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DBConfig.class);
    }
}
