package com.example.question.service;

import com.example.model.*;

public interface IQuestionService {
    public int createQuestion(int userId, QuestionInfo questionInfo);

    public QuestionInfo getQuestion(int questionId);
}
