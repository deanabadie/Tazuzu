package com.tazuzu.user.repository;

import com.tazuzu.organization.domain.Class;
import com.tazuzu.organization.domain.School;
import com.tazuzu.user.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();
    List<Student> findBySchoolClass(Class cls);
    Student findByUserName(String userName);
//    boolean validatePassword(String username, String password);
}