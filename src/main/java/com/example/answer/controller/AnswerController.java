package com.example.answer.controller;

import com.example.answer.model.Answer;
import com.example.answer.service.IAnswerService;
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
    public int createAnswer(@PathVariable int userId, @PathVariable int questionId, @RequestBody Answer answer)
    {
        return IAnswerService.createAnswer(userId, questionId, answer);
    }

    @PostMapping("/users/{userId}/answers/{answerId}/answerLike")
    public void createAnswerLike(@PathVariable int userId, @PathVariable int answerId)
    {
        answerLikeService.createAnswerLike(userId, answerId);
    }
}
