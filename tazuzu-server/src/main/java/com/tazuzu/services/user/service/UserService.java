package com.tazuzu.services.user.service;

import com.tazuzu.services.user.domain.User;

import java.util.Date;
import java.util.List;

/**
 * Created by nati1 on 3/25/15.
 */
public interface UserService {
    public User getUser(long userId);
    public List<User> getAllUsers();
    public User createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);
}
