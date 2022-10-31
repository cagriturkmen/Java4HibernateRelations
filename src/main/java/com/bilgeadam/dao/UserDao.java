package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.User;

import jakarta.persistence.TypedQuery;

public class UserDao implements IRepository<User>{

	@Override
	public void create(User entity) {
		
		Session session = null;
		try {
			session = databaseConnection();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("User data is added to Db.");
		} catch (Exception e) {
			e.getMessage();
			System.err.println("Some problem occured while adding USER data.");
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public void update(long id, User entity) {
		
		Session session = null;
		try {
			User updateUser = find(id);
			updateUser.setEmail(entity.getEmail());
			updateUser.setPassword(entity.getPassword());
			updateUser.setRole(entity.getRole());
		//	updateUser.setUserDetail(entity.getUserDetail());
			
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateUser);
			session.getTransaction().commit();
			System.out.println("Successfully updated.");
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Some problem occured while UPDATING User data.");
		}finally {
			session.close();
		}	
		
	}

	@Override
	public void delete(long id) {
		Session session= null;
		
		try {
			User deleteAddress = find(id);
			if(deleteAddress != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteAddress);
				session.getTransaction().commit();
				
				System.out.println("Successfully deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING User data.");		
		} finally {
			session.close();
		}		
	}

	@Override
	public List<User> listAll() {
		Session session = databaseConnection();
		//hibernate query language
		String hql = "select adr from User as adr";
		
		TypedQuery<User> typedQuery = session.createQuery(hql,User.class);
		List<User> userList = typedQuery.getResultList();
		
		return userList;
	}

	@Override
	public User find(long id) {
		User user = null;
		Session session = databaseConnection();
		
		try {
			user = session.find(User.class, id);
			
			if(user != null) {
				System.out.println("Found user : " + user);
			}else {
				System.out.println("user not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND user data.");
		}finally {
			session.close();
		}
		return user;
	}

}
