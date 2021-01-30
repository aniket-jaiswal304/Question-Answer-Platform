package com.example.dao;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoI extends JpaRepository<User, Integer> {
}
