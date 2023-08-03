package com.example.entity;

import com.example.answer.model.Answer;
import com.example.user.model.User;

import javax.persistence.*;

@Entity
public class AnswerLikes {

    @SequenceGenerator(initialValue = 1, sequenceName = "answerLikeSeq", name = "answerLikeSeq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="answerLikeSeq" )
    private int ansLikeId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Answer answer;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public AnswerLikes() {
    }

    public AnswerLikes(int ansLikeId, Answer answer, User user) {
        this.ansLikeId = ansLikeId;
        this.answer = answer;
        this.user = user;
    }

    public int getAnsLikeId() {
        return ansLikeId;
    }

    public void setAnsLikeId(int ansLikeId) {
        this.ansLikeId = ansLikeId;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
