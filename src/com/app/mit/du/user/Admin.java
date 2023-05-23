package com.app.mit.du.user;

public class Admin extends User {
	public Admin(String username, String password) {
		super(username, password);
		this.username = username;
		this.password = password;
	}

	@Override
	public void displayProfile() {

	}

	public String getUsername() {
		return username;
	}
}
