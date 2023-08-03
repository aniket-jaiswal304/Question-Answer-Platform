package com.example.comment.dao;

import com.example.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerCommentsDao extends JpaRepository<Comment, Integer> {
}
