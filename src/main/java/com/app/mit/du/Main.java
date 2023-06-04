package com.app.mit.du;

import com.app.mit.du.db.DBConnection;
import com.app.mit.du.posts.Post;
import com.app.mit.du.services.SocialMediaServiceImpl;
import com.app.mit.du.user.RegularUser;
import com.app.mit.du.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws SQLException {
		SocialMediaServiceImpl socialMediaServiceImpl = new SocialMediaServiceImpl();
		RegularUser user1 = new RegularUser("rizvi", "rizvi123");
		RegularUser user2 = new RegularUser("rana", "rana123");
		RegularUser user3 = new RegularUser("mahmud", "mahmudl23");

		// add users
		socialMediaServiceImpl.addUser(user1);
		socialMediaServiceImpl.addUser(user2);
		socialMediaServiceImpl.addUser(user3);

		// display users
		ArrayList<User> userList = socialMediaServiceImpl.displayAllUsers();
		System.out.println(userList);

		// Remove User
		socialMediaServiceImpl.removeUser(user3);

		Post post1 = new Post("Hello, we are in MIT classroom", 25);
		Post post2 = new Post(" OOP class is running", 25);
		Post post3 = new Post("We all are doing an assignment on social media app", 25);

		// Add post for every user
		user1.addPost("I live in Australia");
		user2.addPost("I live in America");
		user1.addPost("I live in Canada");

		// Display User Posts
		ArrayList<Post> postFromUser1 = socialMediaServiceImpl.displayUserPosts(user1.getUsername());
		ArrayList<Post> postFromUser2 = socialMediaServiceImpl.displayUserPosts(user2.getUsername());
		ArrayList<Post> postFromUser3 = socialMediaServiceImpl.displayUserPosts(user3.getUsername());

		System.out.println(postFromUser1);
		System.out.println(postFromUser2);
		System.out.println(postFromUser3);

		// Like Posts
		post1.like();
		post2.like();
		post3.like();

		// Unlike posts
		post1.unlike();
		post2.unlike();
		post3.unlike();

		DBConnection dbConnection = new DBConnection();
		dbConnection.getFileFromResources();

	}
}
