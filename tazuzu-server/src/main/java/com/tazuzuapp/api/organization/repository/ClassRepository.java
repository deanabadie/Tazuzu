package com.tazuzuapp.api.organization.repository;

import com.tazuzuapp.api.organization.domain.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    Class findBySchoolNameAndName(String schoolName, String name);
}