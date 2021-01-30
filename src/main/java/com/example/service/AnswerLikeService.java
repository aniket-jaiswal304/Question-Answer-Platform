package com.example.service;

import com.example.dao.AnswerDaoI;
import com.example.dao.AnswerLikesDaoI;
import com.example.dao.UserDaoI;
import com.example.entity.Answer;
import com.example.entity.AnswerLikes;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerLikeService {

    @Autowired
    AnswerLikesDaoI answerLikesDaoI;

    @Autowired
    UserDaoI userDao;

    @Autowired
    AnswerDaoI answerDao;

    public void createAnswerLike(int userId, int answerId)
    {
        Optional<User> userOptional = userDao.findById(userId);
        User user = userOptional.get();

        AnswerLikes answerLike = new AnswerLikes();

        answerLike.setUser(user);

        Optional<Answer> answerOptional = answerDao.findById(answerId);
        Answer answer= answerOptional.get();

        answerLike.setAnswer(answer);

        answerLikesDaoI.save(answerLike);
    }
}
