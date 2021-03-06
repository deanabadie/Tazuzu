package com.tazuzuapp.api.login.controller;

import com.tazuzuapp.api.security.JwtUtil;
import com.tazuzuapp.api.login.domain.LoginRequest;
import com.tazuzuapp.api.login.service.LoginService;
import com.tazuzuapp.api.user.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //Means everything we do will be converted into JSON and be sent as an HTTP response
@CrossOrigin(origins = "*", exposedHeaders = {"Authorization"})
@RequestMapping(value = "/login")
public class LoginController {

    private final LoginService loginService;

    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(LoginService loginService, JwtUtil jwtUtil) {
        this.loginService = loginService;
        this.jwtUtil = jwtUtil;
    }

    @SuppressWarnings("all")
    private static class AuthResponse {
        public long id;

        public String firstName;

        public String lastName;

        public String email;

        public String photoPath;

        public Long govId;

        public Long schoolId;

        public char gender;

        public String userType;

        static AuthResponse fromUserObject(User u) {
            AuthResponse authResponse = new AuthResponse();
            authResponse.id = u.getId();
            authResponse.firstName = u.getFirstName();
            authResponse.lastName = u.getLastName();
            authResponse.gender = u.getGender();
            authResponse.govId = u.getGovId();
            authResponse.photoPath = u.getPhotoPath();
            authResponse.email = u.getEmail();
            authResponse.userType = u instanceof Student ? "Student" : "Teacher";
            authResponse.schoolId = u.getSchool().getId();
            return authResponse;
        }
    }

    @PostMapping
    public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest loginRequest) {

        User user = loginService.login(loginRequest);
        if (user != null) {

            AuthResponse authResponse = AuthResponse.fromUserObject(user);

            HttpHeaders headers = new HttpHeaders();
            Map<String, Object> claims = new HashMap<>();

            claims.put("user", authResponse);

            List<String> auth = new ArrayList<>(1);
            auth.add(jwtUtil.generateToken(claims));
            headers.put("Authorization", auth);

            return new ResponseEntity<>(authResponse, headers, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
