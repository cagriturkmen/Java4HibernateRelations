package com.bilgeadam.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="role_table")
@ToString
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String roleName;
	private String description;
//	private Date createdOn;
	
	@OneToMany(mappedBy = "role")
	private List<User> userList;
	
	@ManyToMany
	@JoinTable(name="role_rule", joinColumns = {@JoinColumn(name ="role_id")},inverseJoinColumns = {@JoinColumn(name="rule_id")} )
	private List<Rule> rules;
	
}
