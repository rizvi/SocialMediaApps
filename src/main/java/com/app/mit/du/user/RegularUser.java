package com.app.mit.du.user;

import java.util.ArrayList;

public class RegularUser extends User {
	public ArrayList<String> posts;

	public RegularUser(String username, String password) {
		super(username, password);
		this.username = username;
		this.password = password;
	}
	public RegularUser(String id, String username, String password) {
		super(id, username, password);
		this.id = id;
		this.username = username;
		this.password = password;
	}
	@Override
	public void displayProfile() {

	}

	public void addPost(String post) {

	}

	@Override
	public String toString() {
		return "RegularUser{" +
				"posts=" + posts +
				", id='" + id + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
