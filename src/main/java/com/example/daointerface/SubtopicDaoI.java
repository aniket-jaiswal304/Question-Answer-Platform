package com.example.daointerface;

import com.example.model.Subtopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtopicDaoI extends JpaRepository<Subtopic, Integer> {
}
