package com.example.dao;

import com.example.entity.QuestionLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionLikesDaoI extends JpaRepository<QuestionLikes, Integer> {
}
