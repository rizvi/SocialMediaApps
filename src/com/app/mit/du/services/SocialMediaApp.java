package com.app.mit.du.services;

import com.app.mit.du.posts.Post;
import com.app.mit.du.user.User;

import java.util.ArrayList;

public class SocialMediaApp {
	ArrayList<User> userList;

	public User addUser(User user) {
		return user;
	}

	public void removeUser(User user) {
	}

	public ArrayList<User> displayAllUsers() {
		ArrayList<User> userList1 = new ArrayList<User>();
		return userList1;
	}

	public ArrayList<Post> displayUserPosts(String username) {
		ArrayList<Post> posts = new ArrayList<Post>();
		return posts;
	}


}
