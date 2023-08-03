package com.example.entity;

import com.example.question.model.Question;
import com.example.user.model.User;

import javax.persistence.*;

@Entity
public class QuestionLikes {

    @SequenceGenerator(initialValue = 1, sequenceName = "questionLikeSeq", name = "questionLikeSeq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="questionLikeSeq" )
    private int quesLikeId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public QuestionLikes() {
    }

    public QuestionLikes(int quesLikeId, Question question, User user) {
        this.quesLikeId = quesLikeId;
        this.question = question;
        this.user = user;
    }

    public int getQuesLikeId() {
        return quesLikeId;
    }

    public void setQuesLikeId(int quesLikeId) {
        this.quesLikeId = quesLikeId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
