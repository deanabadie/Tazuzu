package com.tazuzuapp.api.user.service;

import com.tazuzuapp.api.user.domain.User;
import com.tazuzuapp.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(long id) {
        return this.userRepository.findOne(id);
    }

}
