package com.tazuzuapp.api.user.repository;

import com.tazuzuapp.api.organization.domain.Class;
import com.tazuzuapp.api.user.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();
    List<Student> findBySchoolClass(Class cls);
    List<Student> findBySchoolClassId(Long id);
    List<Student> findAllBySchoolIdAndFirstNameContainingOrLastNameContaining(Long schoolId, String search1, String search2);
}