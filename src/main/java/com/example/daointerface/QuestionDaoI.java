package com.example.daointerface;

import com.example.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDaoI extends JpaRepository<Question, Integer> {
}
