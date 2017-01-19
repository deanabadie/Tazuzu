package com.tazuzu.services.user.repository;

import com.tazuzu.services.user.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

///**
// * Created by Noy on 14/01/2017.
// */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
   List<Teacher> findAll();
}

