package com.bilgeadam.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="rule_table")
@ToString
public class Rule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String ruleName;
	private String description;
	
	@ManyToMany(mappedBy="rules")
	private List<Role> roles;
	
}
