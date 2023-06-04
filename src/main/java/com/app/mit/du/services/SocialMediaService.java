package com.app.mit.du.services;

import com.app.mit.du.posts.Post;
import com.app.mit.du.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SocialMediaService {
    public User addUser(User user) throws SQLException;
    public void removeUser(User user) throws SQLException;
    public ArrayList<User> displayAllUsers() throws SQLException;
    public User getUserByID(String userID) throws SQLException;
    public ArrayList<Post> displayUserPosts(String username);
}
