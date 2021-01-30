package com.example.model;

import java.util.List;

public class AnswerInfo
{
    private int answerId;
    private String answer;
    private List<CommentInfo> comments;
    private Long answerLikes;

    public AnswerInfo() {
    }

    public AnswerInfo(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }

    public AnswerInfo(int answerId, String answer, List<CommentInfo> comments, Long answerLikes) {
        this.answerId = answerId;
        this.answer = answer;
        this.comments = comments;
        this.answerLikes = answerLikes;
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

    public List<CommentInfo> getComments() {
        return comments;
    }

    public void setComments(List<CommentInfo> comments) {
        this.comments = comments;
    }

    public Long getAnswerLikes() {
        return answerLikes;
    }

    public void setAnswerLikes(Long answerLikes) {
        this.answerLikes = answerLikes;
    }
}
