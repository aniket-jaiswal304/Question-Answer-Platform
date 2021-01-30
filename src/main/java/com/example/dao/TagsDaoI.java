package com.example.dao;

import com.example.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsDaoI extends JpaRepository<Tags, Integer> {
}
