package com.example.dao;

import com.example.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDaoI extends JpaRepository<Question, Integer> {
}
