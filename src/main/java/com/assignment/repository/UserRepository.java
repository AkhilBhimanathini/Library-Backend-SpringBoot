package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    // public User findByEmailId(String email);
}
