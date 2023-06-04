package com.app.mit.du.repository;

import com.app.mit.du.db.DBConnection;
import com.app.mit.du.posts.Post;
import com.app.mit.du.user.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class SocialMediaRepositoryImpl implements SocialMediaRepository {
    DBConnection connection = new DBConnection();
    @Override
    public User addUser(User user) throws SQLException {
        connection.getFileFromResources();
        User existingUser = connection.getUserByName(user.getUsername());
        if(existingUser == null) {
            connection.insert(user);
        }
        return user;
    }

    @Override
    public void removeUser(User user) throws SQLException {
        connection.getFileFromResources();
        connection.delete(user.getId());
    }

    @Override
    public ArrayList<User> displayAllUsers() throws SQLException {
        connection.getFileFromResources();
        return connection.getAllUser();
    }

    @Override
    public User getUserByID(String userID) throws SQLException {
        connection.getFileFromResources();
        return connection.getUserByID(userID);
    }

    @Override
    public ArrayList<Post> displayUserPosts(String username) {
        ArrayList<Post> posts = new ArrayList<Post>();
        return posts;
    }
}
