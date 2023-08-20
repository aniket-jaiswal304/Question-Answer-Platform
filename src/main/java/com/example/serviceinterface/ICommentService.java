package com.example.serviceinterface;

import com.example.model.Comment;

public interface ICommentService {
    public int createComment(int userId, int answerId, Comment comment);
}
