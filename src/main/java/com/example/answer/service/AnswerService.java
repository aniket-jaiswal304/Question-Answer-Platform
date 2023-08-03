package com.example.answer.service;

import com.example.answer.dao.IAnswerDao;
import com.example.question.dao.QuestionDaoI;
import com.example.user.dao.IUserDao;
import com.example.answer.model.Answer;
import com.example.question.model.Question;
import com.example.user.model.User;
import com.example.model.AnswerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService implements IAnswerService {

    @Autowired
    IAnswerDao IAnswerDao;

    @Autowired
    IUserDao userDao;

    @Autowired
    QuestionDaoI questionDao;

    @Override
    public int createAnswer(int userId, int questionId, AnswerInfo answerInfo)
    {
        Optional<User> userOptional = userDao.findById(userId);
        User user = userOptional.get();

        Optional<Question> questionOptional = questionDao.findById(questionId);
        Question question = questionOptional.get();

        Answer answer = new Answer(answerInfo.getAnswerId(), answerInfo.getAnswer(), question, user);

        IAnswerDao.save(answer);

        return answer.getAnswerId();
    }
}
