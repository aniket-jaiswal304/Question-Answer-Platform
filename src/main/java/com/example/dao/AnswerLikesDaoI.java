package com.example.dao;

import com.example.entity.AnswerLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerLikesDaoI extends JpaRepository<AnswerLikes, Integer> {
}
