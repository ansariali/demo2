package com.crud.repository;

import com.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(@Param("userName") String userName);

    @Query("SELECT o FROM User AS o WHERE o.email = :email")
    User findByEmail(@Param("email") String email);
}
