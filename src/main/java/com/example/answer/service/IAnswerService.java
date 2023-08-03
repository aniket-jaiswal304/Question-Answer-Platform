package com.example.answer.service;

import com.example.answer.model.Answer;

public interface IAnswerService {
    public int createAnswer(int userId, int questionId, Answer answer);
}
