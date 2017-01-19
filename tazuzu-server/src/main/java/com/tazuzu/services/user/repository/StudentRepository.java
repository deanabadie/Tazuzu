package com.tazuzu.services.user.repository;

import com.tazuzu.services.user.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

///**
// * Created by Noy on 14/01/2017.
// */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();
}