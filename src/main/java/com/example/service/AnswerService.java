package com.example.service;

import com.example.daointerface.IAnswerDao;
import com.example.daointerface.QuestionDaoI;
import com.example.daointerface.IUserDao;
import com.example.model.Answer;
import com.example.model.Question;
import com.example.model.User;
import com.example.serviceinterface.IAnswerService;
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
    public int createAnswer(int userId, int questionId, Answer answer)
    {
        Optional<User> userOptional = userDao.findById(userId);
        User user = userOptional.get();

        Optional<Question> questionOptional = questionDao.findById(questionId);
        Question question = questionOptional.get();

        IAnswerDao.save(answer);

        return answer.getAnswerId();
    }
}
