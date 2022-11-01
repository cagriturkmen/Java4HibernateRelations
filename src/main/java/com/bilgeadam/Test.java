package com.bilgeadam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.bilgeadam.dao.RoleDao;
import com.bilgeadam.dao.RuleDao;
import com.bilgeadam.dao.UserDao;
import com.bilgeadam.entity.Gender;
import com.bilgeadam.entity.Role;
import com.bilgeadam.entity.Rule;
import com.bilgeadam.entity.User;
import com.bilgeadam.entity.UserDetail;


public class Test {

	public static void main(String[] args) {
		RuleDao ruleDao = new RuleDao();
		RoleDao roleDao = new RoleDao();
		UserDao userDao = new UserDao();
		
	//
		Role role = new Role();
		role.setRoleName("student");
		role.setDescription("work hard");
		
		Role role2 = new Role();
		role2.setRoleName("teacher");
		role2.setDescription("teaches well");
	//	
		Rule rule = new Rule();
		rule.setRuleName("LOGIN");
		rule.setDescription("Authorization for logging in");
		
		Rule rule2 = new Rule();
		rule2.setRuleName("EXAM_UPDATE");
		rule2.setDescription("Updating exam questions");
		
		User user = new User();
		user.setEmail("cagri@mail.çcom");
		user.setPassword("123");
		user.setRole(role2);
		
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstname("Cagri");
		userDetail.setGender(Gender.MAN);
		userDetail.setBio("dasdsad");
		
		FileInputStream input;
		
		try {
			input = new FileInputStream(new File("C:\\Users\\cturk\\BilgeAdamJava4\\HibernateRelations\\maticpunk.jpg"));
			userDetail.setPicture(IOUtils.toByteArray(input));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.setUserDetail(userDetail);
		
		userDao.create(user);
//		---------------------------------------
		List<Rule> ruleList1 = new ArrayList<>();
		ruleList1.add(rule);
		List<Rule> ruleList2 = new ArrayList<>();
		ruleList2.add(rule2);
		ruleList2.add(rule);
		role.setRules(ruleList1);
		role2.setRules(ruleList2);
		ruleDao.create(rule2);
		ruleDao.create(rule);
		roleDao.create(role2);
		roleDao.create(role);
		
		
		
	}

}
