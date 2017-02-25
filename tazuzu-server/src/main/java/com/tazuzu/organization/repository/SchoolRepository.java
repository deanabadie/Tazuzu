package com.tazuzu.organization.repository;

import com.tazuzu.organization.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    School findByName(String name);
}

