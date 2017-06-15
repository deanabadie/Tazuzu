package com.tazuzuapp.api.organization.repository;

import com.tazuzuapp.api.organization.domain.Class;
import com.tazuzuapp.api.organization.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    Class findBySchoolNameAndName(String schoolName, String name);
    List<Class> findBySchool(School school);
    List<Class> findById(Long id);
}