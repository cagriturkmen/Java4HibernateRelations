package com.bilgeadam.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


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
		
		
		
		SessionFactory sessionFactory = conf.configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("Connection to PostgreSQL via Hibernate is successful.");
		return sessionFactory;
	}
	
	
}
