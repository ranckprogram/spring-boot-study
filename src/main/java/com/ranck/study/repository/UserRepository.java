package com.ranck.study.repository;

import com.ranck.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findAllById(Integer payerId);

    List<User> findUsersByNameStartingWith(String username);


    // User 类名，不是表名
    @Query("select o from User o where id = (select max(id) from User t1)")
    User getUserForMaxId () ;

    @Query("select o from User o where o.name like %:name%")
    List<User> getUserForNameLike(@Param("name")String name);
}
