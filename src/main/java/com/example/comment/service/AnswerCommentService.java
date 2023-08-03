package com.example.comment.service;

import com.example.comment.dao.IAnswerCommentsDao;
import com.example.answer.dao.IAnswerDao;
import com.example.user.dao.IUserDao;
import com.example.answer.model.Answer;
import com.example.comment.model.Comment;
import com.example.user.model.User;
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
