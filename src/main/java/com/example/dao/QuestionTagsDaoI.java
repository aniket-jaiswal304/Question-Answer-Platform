package com.example.dao;

import com.example.entity.QuestionTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTagsDaoI extends JpaRepository<QuestionTags, Integer> {
}
