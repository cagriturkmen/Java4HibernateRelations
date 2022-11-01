package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.User;
import com.bilgeadam.entity.UserDetail;

import jakarta.persistence.TypedQuery;

public class UserDetailDao implements IRepository<UserDetail>{

	@Override
	public void create(UserDetail entity) {
		
		Session session = null;
		try {
			session = databaseConnection();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("UserDetail data is added to Db.");
		} catch (Exception e) {
			e.getMessage();
			System.err.println("Some problem occured while adding UserDetail data.");
		}finally {
			session.close();
		}		
	}
	
	@Override
	public void update(long id, UserDetail entity) {
		
		Session session = null;
		try {
			UserDetail updateUser = find(id);
			updateUser.setFirstname(entity.getFirstname());
			updateUser.setLastname(entity.getLastname());
			updateUser.setBio(entity.getBio());
			updateUser.setGender(entity.getGender());
			updateUser.setPicture(entity.getPicture());
		//	updateUser.setUserDetail(entity.getUserDetail());
			
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateUser);
			session.getTransaction().commit();
			System.out.println("Successfully updated.");
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Some problem occured while UPDATING UserDetail data.");
		}finally {
			session.close();
		}	
		
	}

	@Override
	public void delete(long id) {
		Session session= null;
		
		try {
			UserDetail deleteUserDetail = find(id);
			if(deleteUserDetail != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteUserDetail);
				session.getTransaction().commit();
				
				System.out.println("Successfully deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING UserDetail data.");		
		} finally {
			session.close();
		}		
	}

	@Override
	public List<UserDetail> listAll() {
		Session session = databaseConnection();
		//hibernate query language
		String hql = "select adr from UserDetail as adr";
		
		TypedQuery<UserDetail> typedQuery = session.createQuery(hql,UserDetail.class);
		List<UserDetail> userList = typedQuery.getResultList();
		
		return userList;
	}

	@Override
	public UserDetail find(long id) {
		UserDetail userDetail = null;
		Session session = databaseConnection();
		
		try {
			userDetail = session.find(UserDetail.class, id);
			
			if(userDetail != null) {
				System.out.println("Found UserDetail : " + userDetail);
			}else {
				System.out.println("UserDetail not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND UserDetail data.");
		}finally {
			session.close();
		}
		return userDetail;
	}

}
