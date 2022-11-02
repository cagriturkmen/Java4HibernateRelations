package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.Role;
import com.bilgeadam.entity.User;

import jakarta.persistence.TypedQuery;

public class RoleDao implements IRepository<Role>{

	@Override
	public void create(Role entity) {
		
		Session session = null;
		try {
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(entity);
			session.getTransaction().commit();
			System.out.println("Role data is added to Db.");
		} catch (Exception e) {
			System.out.println( e.getMessage());;
			System.err.println("Some problem occured while adding Role data.");
			e.printStackTrace();
		}finally {
			session.close();
		}		
	}
	
	@Override
	public void update(long id, Role entity) {
		
		Session session = null;
		try {
			Role role = find(id);
			role.setRoleName(entity.getRoleName());
			role.setRules(entity.getRules());
			role.setDescription(entity.getDescription());
		//	updateUser.setUserDetail(entity.getUserDetail());
			
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(role);
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
			Role deleteAddress = find(id);
			if(deleteAddress != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteAddress);
				session.getTransaction().commit();
				
				System.out.println("Successfully deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING Role data.");		
		} finally {
			session.close();
		}		
	}

	@Override
	public List<Role> listAll() {
		Session session = databaseConnection();
		//hibernate query language
		String hql = "select adr from Role as adr";
		
		TypedQuery<Role> typedQuery = session.createQuery(hql,Role.class);
		List<Role> userList = typedQuery.getResultList();
		
		return userList;
	}

	@Override
	public Role find(long id) {
		Role user = null;
		Session session = databaseConnection();
		
		try {
			user = session.find(Role.class, id);
			
			if(user != null) {
				System.out.println("Found Role : " + user);
			}else {
				System.out.println("Role not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND Role data.");
		}finally {
			session.close();
		}
		return user;
	}

}
