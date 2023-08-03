package com.example.answer.dao;

import com.example.answer.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerDao extends JpaRepository<Answer, Integer> {
}
