package com.example.comment.service;

import com.example.comment.model.Comment;

public interface ICommentService {
    public int createComment(int userId, int answerId, Comment comment);
}
