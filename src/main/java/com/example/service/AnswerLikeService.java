package com.example.service;

import com.example.daointerface.IAnswerDao;
import com.example.daointerface.AnswerLikesDaoI;
import com.example.daointerface.IUserDao;
import com.example.model.Answer;
import com.example.entity.AnswerLikes;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerLikeService {

    @Autowired
    AnswerLikesDaoI answerLikesDaoI;

    @Autowired
    IUserDao userDao;

    @Autowired
    IAnswerDao IAnswerDao;

    public void createAnswerLike(int userId, int answerId)
    {
        Optional<User> userOptional = userDao.findById(userId);
        User user = userOptional.get();

        AnswerLikes answerLike = new AnswerLikes();

        answerLike.setUser(user);

        Optional<Answer> answerOptional = IAnswerDao.findById(answerId);
        Answer answer= answerOptional.get();

        answerLike.setAnswer(answer);

        answerLikesDaoI.save(answerLike);
    }
}
