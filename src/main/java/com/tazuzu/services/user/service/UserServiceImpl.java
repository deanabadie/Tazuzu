package com.tazuzu.services.user.service;

import com.tazuzu.services.user.*;
import com.tazuzu.services.user.domain.User;
import com.tazuzu.services.user.repository.UserRepository;
import org.hibernate.NonUniqueObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by nati1 on 3/25/15.
 */
@Service
class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(long userId) {
        return userRepository.getOne(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.delete(userId);
    }
}