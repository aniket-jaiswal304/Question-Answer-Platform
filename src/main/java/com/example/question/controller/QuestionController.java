package com.example.question.controller;

import com.example.question.model.Question;
import com.example.question.service.IQuestionService;
import com.example.question.service.QuestionService;
import com.example.service.QuestionLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    IQuestionService questionService;

    @Autowired
    QuestionLikeService questionLikeService;

    @PostMapping("/users/{userId}/questions")
    public int createQuestion(@PathVariable int userId, @RequestBody Question question)
    {
        return questionService.createQuestion(userId, question);
    }

    @GetMapping("/question/{questionId}")
    public Question getQuestion(@PathVariable int questionId)
    {
        return questionService.getQuestion(questionId);
    }

    @PostMapping("/users/{userId}/questions/{questionId}/questionLike")
    public void createQuestionLike(@PathVariable int userId, @PathVariable int questionId)
    {
        questionLikeService.createQuestionLike(userId, questionId);
    }
}
