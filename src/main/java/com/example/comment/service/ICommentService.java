package com.example.comment.service;

import com.example.model.CommentInfo;

public interface ICommentService {
    public int createComment(int userId, int answerId, CommentInfo commentInfo);
}
