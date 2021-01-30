package com.example.dao;

import com.example.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDaoI extends JpaRepository<Answer, Integer> {
}
