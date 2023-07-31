package com.example.topic.dao;

import com.example.topic.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicDaoI extends JpaRepository<Topic, Integer> {
}
