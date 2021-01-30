package com.example.dao;

import com.example.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicDaoI extends JpaRepository<Topic, Integer> {
}
