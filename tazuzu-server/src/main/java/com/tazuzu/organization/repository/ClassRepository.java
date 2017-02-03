package com.tazuzu.organization.repository;

import com.tazuzu.organization.domain.Class;
import com.tazuzu.organization.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    Class findBySchoolNameAndName(String schoolName, String name);
}