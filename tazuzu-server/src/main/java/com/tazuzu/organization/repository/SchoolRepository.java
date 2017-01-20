package com.tazuzu.organization.repository;

import com.tazuzu.organization.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/schools")
public interface SchoolRepository extends JpaRepository<School, Long> {}