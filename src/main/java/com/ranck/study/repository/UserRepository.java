package com.ranck.study.repository;

import com.ranck.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findAllById(Integer payerId);

    List<User> findUsersByNameStartingWith(String username);
}
