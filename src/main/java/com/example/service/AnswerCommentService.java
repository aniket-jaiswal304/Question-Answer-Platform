package com.example.service;

import com.example.dao.AnswerCommentsDaoI;
import com.example.dao.AnswerDaoI;
import com.example.dao.UserDaoI;
import com.example.entity.Answer;
import com.example.entity.Comment;
import com.example.entity.User;
import com.example.model.CommentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerCommentService {

    @Autowired
    AnswerCommentsDaoI answerCommentsDao;

    @Autowired
    UserDaoI userDao;

    @Autowired
    AnswerDaoI answerDao;

    public int createComment(int userId, int answerId, CommentInfo commentInfo)
    {
        Optional<User> userOptional = userDao.findById(userId);
        User user = userOptional.get();


        Optional<Answer> answerOptional = answerDao.findById(answerId);
        Answer answer = answerOptional.get();


        Comment commentEntity = new Comment(commentInfo.getCommentId(), commentInfo.getComment(), answer, user);

        //save answer to the database
        answerCommentsDao.save(commentEntity);

        return  commentEntity.getCommentId();
    }
}
