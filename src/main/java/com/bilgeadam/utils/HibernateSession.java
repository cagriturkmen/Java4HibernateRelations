package com.bilgeadam.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.Role;
import com.bilgeadam.entity.Rule;
import com.bilgeadam.entity.User;
import com.bilgeadam.entity.UserDetail;


public class HibernateSession {
	
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {	
		
		if(HibernateSession.sessionFactory == null ) {	
			HibernateSession.sessionFactory = createSessionFactory();
			}
		return HibernateSession.sessionFactory;
		
		
	}
	private static SessionFactory createSessionFactory() {
		Configuration conf = new Configuration();	
		
		//Entityleri configration'a ekleyeceğim.
		conf.addAnnotatedClass(User.class);
		conf.addAnnotatedClass(UserDetail.class);
		conf.addAnnotatedClass(Role.class);
		conf.addAnnotatedClass(Rule.class);
		
		SessionFactory sessionFactory = conf.configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("Connection to PostgreSQL via Hibernate is successful.");
		return sessionFactory;
	}
	
	
}
