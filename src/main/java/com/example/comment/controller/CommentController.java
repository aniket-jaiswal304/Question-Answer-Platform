package com.example.comment.controller;

import com.example.comment.model.Comment;
import com.example.comment.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    ICommentService answerCommentService;

    @PostMapping("/users/{userId}/answers/{answerId}/comments")
    public int createComment(@PathVariable int userId, @PathVariable int answerId, @RequestBody Comment comment)
    {
        return answerCommentService.createComment(userId, answerId, comment);
    }
}
