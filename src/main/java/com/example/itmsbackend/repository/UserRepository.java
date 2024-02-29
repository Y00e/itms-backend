package com.example.itmsbackend.repository;

import com.example.itmsbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
}
