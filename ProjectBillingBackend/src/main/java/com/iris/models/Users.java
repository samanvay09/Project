package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="User1")
public class Users {

	@Id
    @Column(name="UserId")
	private int userId;
	
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Role")
	private String role;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	 
	
	
	
	
	
}
