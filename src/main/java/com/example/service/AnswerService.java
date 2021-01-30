package com.example.service;

import com.example.dao.AnswerDaoI;
import com.example.dao.QuestionDaoI;
import com.example.dao.UserDaoI;
import com.example.entity.Answer;
import com.example.entity.Question;
import com.example.entity.User;
import com.example.model.AnswerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    AnswerDaoI answerDao;

    @Autowired
    UserDaoI userDao;

    @Autowired
    QuestionDaoI questionDao;

    public int createAnswer(int userId, int questionId, AnswerInfo answerInfo)
    {
        Optional<User> userOptional = userDao.findById(userId);
        User user = userOptional.get();

        Optional<Question> questionOptional = questionDao.findById(questionId);
        Question question = questionOptional.get();

        Answer answer = new Answer(answerInfo.getAnswerId(), answerInfo.getAnswer(), question, user);

        answerDao.save(answer);

        return answer.getAnswerId();
    }
}
