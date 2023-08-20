package com.example.daointerface;

import com.example.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerCommentsDao extends JpaRepository<Comment, Integer> {
}
