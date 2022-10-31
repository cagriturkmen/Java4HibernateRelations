package com.bilgeadam.entity;

import java.util.List;

public class Role {
	
	private long id;
	private String roleName;
	private String description;
//	private Date createdOn;
	
	private List<User> userList;
	
	private List<Rule> rules;
	
}
