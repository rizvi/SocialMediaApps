package com.app.mit.du.user;

public abstract class User {
	String username;
	String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public abstract void displayProfile();

}
