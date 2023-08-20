package com.example.serviceinterface;

import com.example.model.Answer;

public interface IAnswerService {
    public int createAnswer(int userId, int questionId, Answer answer);
}
