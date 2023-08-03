package com.example.answer.controller;

import com.example.answer.service.IAnswerService;
import com.example.model.AnswerInfo;
import com.example.service.AnswerLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/answer")
public class AnswerController {

    @Autowired
    IAnswerService IAnswerService;

    @Autowired
    AnswerLikeService answerLikeService;

    @PostMapping("/users/{userId}/questions/{questionId}/answers")
    public int createAnswer(@PathVariable int userId, @PathVariable int questionId, @RequestBody AnswerInfo answerInfo)
    {
        return IAnswerService.createAnswer(userId, questionId, answerInfo);
    }

    @PostMapping("/users/{userId}/answers/{answerId}/answerLike")
    public void createAnswerLike(@PathVariable int userId, @PathVariable int answerId)
    {
        answerLikeService.createAnswerLike(userId, answerId);
    }
}
