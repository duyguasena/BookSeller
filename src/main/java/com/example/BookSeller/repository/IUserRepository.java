package com.example.BookSeller.repository;

import com.example.BookSeller.model.Role;
import com.example.BookSeller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;


public interface IUserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String userName);

    @Modifying
    @Query("update User set role = :role where userName = :userName")
    void updateUserRole(@Param("userName") String username, @Param("role") Role role);

}
