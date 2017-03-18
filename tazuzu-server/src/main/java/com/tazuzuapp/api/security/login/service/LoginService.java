package com.tazuzuapp.api.security.login.service;

import com.tazuzuapp.api.security.login.domain.LoginRequest;
import com.tazuzuapp.api.user.domain.Student;
import com.tazuzuapp.api.user.domain.Teacher;
import com.tazuzuapp.api.user.domain.User;
import com.tazuzuapp.api.user.repository.StudentRepository;
import com.tazuzuapp.api.user.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {

    StudentRepository studentRepository;
    TeacherRepository teacherRepository;

    @Autowired
    public LoginService(StudentRepository studentRepository, TeacherRepository teacherRepository){
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }
    @Transactional
    public User login(LoginRequest loginRequest) {
        Student student = studentRepository.findByUserName(loginRequest.getUserName());
        Teacher teacher = teacherRepository.findByUserName(loginRequest.getUserName());
        if (student!=null) {
//            boolean match = studentRepository.validatePassword(username,password);
            boolean match = student.getPassword().equals(loginRequest.getPassword());
            if (match) {
                return student;
            }
            else{
                //TODO: change to more informative return type
                return null;
            }
        }
        else {
            boolean match = teacher.getPassword().equals(loginRequest.getPassword());
            if (match) {
                return teacher;
            } else {
                //TODO: change to more informative return type
                return null;
            }
        }
    }
}
