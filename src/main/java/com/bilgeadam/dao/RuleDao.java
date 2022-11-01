package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.Rule;

import jakarta.persistence.TypedQuery;

public class RuleDao implements IRepository<Rule>{

	@Override
	public void create(Rule entity) {
		
		Session session = null;
		try {
			session = databaseConnection();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Rule data is added to Db.");
		} catch (Exception e) {
			e.getMessage();
			System.err.println("Some problem occured while adding Rule data.");
		}finally {
			session.close();
		}		
	}
	
	@Override
	public void update(long id, Rule entity) {
		
		Session session = null;
		try {
			Rule Rule = find(id);
			Rule.setRuleName(entity.getRuleName());
			Rule.setRoles(entity.getRoles());
			Rule.setDescription(entity.getDescription());
		//	updateUser.setUserDetail(entity.getUserDetail());
			
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(Rule);
			session.getTransaction().commit();
			System.out.println("Successfully updated.");
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Some problem occured while UPDATING Rule data.");
		}finally {
			session.close();
		}	
		
	}

	@Override
	public void delete(long id) {
		Session session= null;
		
		try {
			Rule deleteAddress = find(id);
			if(deleteAddress != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteAddress);
				session.getTransaction().commit();
				
				System.out.println("Successfully deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING Rule data.");		
		} finally {
			session.close();
		}		
	}

	@Override
	public List<Rule> listAll() {
		Session session = databaseConnection();
		//hibernate query language
		String hql = "select adr from Rule as adr";
		
		TypedQuery<Rule> typedQuery = session.createQuery(hql,Rule.class);
		List<Rule> userList = typedQuery.getResultList();
		
		return userList;
	}

	@Override
	public Rule find(long id) {
		Rule user = null;
		Session session = databaseConnection();
		
		try {
			user = session.find(Rule.class, id);
			
			if(user != null) {
				System.out.println("Found Rule : " + user);
			}else {
				System.out.println("Rule not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND Rule data.");
		}finally {
			session.close();
		}
		return user;
	}

}
