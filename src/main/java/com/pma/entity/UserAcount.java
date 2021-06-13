package com.pma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_accounts")
public class UserAcount {
	@Id
	
	private long userId;
	@Column(name = "username")
	private String userName;
	
	
	
}
