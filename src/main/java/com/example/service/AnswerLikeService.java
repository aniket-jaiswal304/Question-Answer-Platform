package com.example.service;

import com.example.answer.dao.IAnswerDao;
import com.example.dao.AnswerLikesDaoI;
import com.example.user.dao.IUserDao;
import com.example.answer.model.Answer;
import com.example.entity.AnswerLikes;
import com.example.user.model.User;
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
