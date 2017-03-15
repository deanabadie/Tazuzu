package com.tazuzu.security.login.service;

import com.tazuzu.security.login.domain.LoginRequest;
import com.tazuzu.user.domain.Student;
import com.tazuzu.user.domain.Teacher;
import com.tazuzu.user.domain.User;
import com.tazuzu.user.repository.StudentRepository;
import com.tazuzu.user.repository.TeacherRepository;
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
