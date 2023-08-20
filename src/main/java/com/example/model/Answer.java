package com.example.model;

import com.example.entity.AnswerLikes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Answer {

    @SequenceGenerator(initialValue = 1, sequenceName = "answerSeq", name = "answerSeq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="answerSeq" )
    private int answerId;
    @NotNull
    @Size(min = 50, max = 500, message = "Mandatory. Min length 50 characters, Max length 500")
    private String answer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToMany(mappedBy = "answer")
    private List<Comment> comments;
    @OneToMany(mappedBy = "answer")
    private List<AnswerLikes> answerLikes;

    public Answer() {
    }

    public Answer(int answerId, String answer, Question question, User user) {
        this.answerId = answerId;
        this.answer = answer;
        this.question = question;
        this.user = user;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<AnswerLikes> getAnswerLikes() {
        return answerLikes;
    }

    public void setAnswerLikes(List<AnswerLikes> answerLikes) {
        this.answerLikes = answerLikes;
    }

    @Override
    public String toString() {
        return "AnswerInfo{" +
                "ansId=" + answerId +
                ", answer='" + answer + '\'' +
                '}';
    }
}
