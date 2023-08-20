package com.example.service;

import com.example.daointerface.IAnswerCommentsDao;
import com.example.daointerface.IAnswerDao;
import com.example.daointerface.IUserDao;
import com.example.model.Answer;
import com.example.model.Comment;
import com.example.model.User;
import com.example.serviceinterface.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerCommentService implements ICommentService {

    @Autowired
    IAnswerCommentsDao answerCommentsDao;

    @Autowired
    IUserDao userDao;

    @Autowired
    IAnswerDao IAnswerDao;

    public int createComment(int userId, int answerId, Comment comment)
    {
        Optional<User> userOptional = userDao.findById(userId);
        User user = userOptional.get();


        Optional<Answer> answerOptional = IAnswerDao.findById(answerId);
        Answer answer = answerOptional.get();

        //save answer to the database
        answerCommentsDao.save(comment);

        return  comment.getCommentId();
    }
}
