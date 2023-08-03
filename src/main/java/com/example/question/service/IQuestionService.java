package com.example.question.service;

import com.example.question.model.Question;

public interface IQuestionService {
    public int createQuestion(int userId, Question question);

    public Question getQuestion(int questionId);
}
