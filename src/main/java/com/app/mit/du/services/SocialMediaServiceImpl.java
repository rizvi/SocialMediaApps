package com.app.mit.du.services;

import com.app.mit.du.posts.Post;
import com.app.mit.du.repository.SocialMediaRepositoryImpl;
import com.app.mit.du.user.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class SocialMediaServiceImpl implements SocialMediaService {
    SocialMediaRepositoryImpl socialMediaRepository = new SocialMediaRepositoryImpl();

    public User addUser(User user) throws SQLException {
        return socialMediaRepository.addUser(user);
    }

    public void removeUser(User user) throws SQLException {
        socialMediaRepository.removeUser(user);
    }

    public ArrayList<User> displayAllUsers() throws SQLException {
        return socialMediaRepository.displayAllUsers();
    }

    @Override
    public User getUserByID(String userID) throws SQLException {
        return socialMediaRepository.getUserByID(userID);
    }

    public ArrayList<Post> displayUserPosts(String username) {
        return socialMediaRepository.displayUserPosts(username);
    }


}
