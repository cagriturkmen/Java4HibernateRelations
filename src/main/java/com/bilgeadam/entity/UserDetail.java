package com.bilgeadam.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_detail_table")
@ToString
public class UserDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstname;
	private String lastname;
	private String bio;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Lob
	private byte[] picture;
	
	@OneToOne(mappedBy="userDetail")
	private User user;
	
}
