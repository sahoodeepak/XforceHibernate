package com.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class Userinfo {

	@Id
	@Column(name = "user_id")
	private int User_id;
	@Column(name = "first_name")
	private String FirstName;
	@Column(name = "last_name")
	private String LastName;
	@Column(name = "email")
	private String Email_id;
	@Column(name = "password")
	private String Password;

	public int getUser_id() {
		return User_id;
	}

	public void setUser_id(int user_id) {
		User_id = user_id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {

		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail_id() {
		return Email_id;
	}

	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Userinfo [User_id=" + User_id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email_id="
				+ Email_id + ", Password=" + Password + "]";
	}

}
