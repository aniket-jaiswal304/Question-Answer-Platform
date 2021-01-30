package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @SequenceGenerator(initialValue = 1, sequenceName = "userSeq", name = "userSeq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="userSeq" )
    private int userId;
    private String userName;
    @OneToMany(mappedBy = "user")
    private List<Question> questions;
    @OneToMany(mappedBy = "user")
    private List<Answer> answers;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    @OneToMany(mappedBy = "user")
    private List<QuestionLikes> questionLikes;
    @OneToMany(mappedBy = "user")
    private List<AnswerLikes> answerLikes;

    public User() {
    }

    public User(int userId, String userName, List<Question> questions, List<Answer> answers, List<Comment> comments, List<QuestionLikes> questionLikes, List<AnswerLikes> answerLikes) {
        this.userId = userId;
        this.userName = userName;
        this.questions = questions;
        this.answers = answers;
        this.comments = comments;
        this.questionLikes = questionLikes;
        this.answerLikes = answerLikes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<QuestionLikes> getQuestionLikes() {
        return questionLikes;
    }

    public void setQuestionLikes(List<QuestionLikes> questionLikes) {
        this.questionLikes = questionLikes;
    }

    public List<AnswerLikes> getAnswerLikes() {
        return answerLikes;
    }

    public void setAnswerLikes(List<AnswerLikes> answerLikes) {
        this.answerLikes = answerLikes;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
