package com.example.controller;

import com.example.model.Comment;
import com.example.serviceinterface.ICommentService;
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
