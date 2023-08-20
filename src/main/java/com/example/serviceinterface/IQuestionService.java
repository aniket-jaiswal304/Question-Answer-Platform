package com.example.serviceinterface;

import com.example.model.Question;
import org.springframework.stereotype.Service;

@Service
public interface IQuestionService {
    public int createQuestion(int userId, Question question);

    public Question getQuestion(int questionId);
}
