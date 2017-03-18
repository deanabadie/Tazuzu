package com.tazuzuapp.api.security.login.webController;

import com.tazuzuapp.api.security.login.domain.LoginRequest;
import com.tazuzuapp.api.security.login.service.LoginService;
import com.tazuzuapp.api.user.domain.Student;
import com.tazuzuapp.api.user.domain.Teacher;
import com.tazuzuapp.api.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController //Means everything we do will be converted into JSON and be sent as an HTTP response
@CrossOrigin(origins = "*")
@RequestMapping(value = "/login")
public class LoginController {
    private final LoginService service;

    @Autowired
    public LoginController(LoginService loginService) {
        this.service = loginService;
    }

    @PostMapping
    public ResponseEntity<User> login (@RequestBody LoginRequest loginRequest) {

        User user = service.login(loginRequest);
        if (user == null) {
            throw new EntityNotFoundException("No such username " + loginRequest.getUserName());
        } else if (user instanceof Student) {
            Student s = (Student) user;
            return new ResponseEntity<>(s, HttpStatus.CREATED);
        }
        else{
            Teacher t = (Teacher) user;
            return new ResponseEntity<>(t, HttpStatus.CREATED);
        }
    }
}
