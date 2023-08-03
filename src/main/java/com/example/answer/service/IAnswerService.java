package com.example.answer.service;

import com.example.model.AnswerInfo;

public interface IAnswerService {
    public int createAnswer(int userId, int questionId, AnswerInfo answerInfo);
}
