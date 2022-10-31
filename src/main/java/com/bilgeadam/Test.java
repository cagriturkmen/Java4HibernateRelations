package com.bilgeadam;

import com.bilgeadam.dao.UserDao;
import com.bilgeadam.entity.Role;
import com.bilgeadam.entity.User;

public class Test {

	public static void main(String[] args) {
		Role role = new Role();
		role.setRoleName("student");
		role.setDescription("work hard");
		
		User user = new User();
		user.setEmail("cagri@mail.çcom");
		user.setPassword("123");
		user.setRole(role);
		
		UserDao userDao = new UserDao();
		userDao.create(user);
	}

}
