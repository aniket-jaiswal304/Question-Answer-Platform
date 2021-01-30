package com.example.service;

import com.example.dao.QuestionDaoI;
import com.example.dao.QuestionLikesDaoI;
import com.example.dao.UserDaoI;
import com.example.entity.Question;
import com.example.entity.QuestionLikes;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionLikeService {

    @Autowired
    QuestionLikesDaoI questionLikesDao;

    @Autowired
    UserDaoI userDao;

    @Autowired
    QuestionDaoI questionDao;

    public void createQuestionLike(int userId, int questionId)
    {
        Optional<User> userOptional = userDao.findById(userId);
        User user = userOptional.get();

        QuestionLikes questionLike = new QuestionLikes();

        questionLike.setUser(user);

        Optional<Question> questionOptional = questionDao.findById(questionId);
        Question question = questionOptional.get();

        //map the question to the answer
        questionLike.setQuestion(question);

        questionLikesDao.save(questionLike);
    }
}
