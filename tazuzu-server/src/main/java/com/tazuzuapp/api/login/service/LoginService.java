package com.tazuzuapp.api.login.service;

import com.tazuzuapp.api.login.domain.LoginRequest;
import com.tazuzuapp.api.user.domain.User;
import com.tazuzuapp.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {

    private UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public User login(LoginRequest loginRequest) {
        User u = this.userRepository.findByGovId(loginRequest.getIdNumber());

        if (u != null) {
            if (u.getPassword().equals(loginRequest.getPassword())) {
                return u;
            }
        }

        return null;
    }
}
