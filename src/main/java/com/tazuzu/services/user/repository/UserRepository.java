package com.tazuzu.services.user.repository;

import com.tazuzu.services.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nati1 on 3/25/15.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
}
