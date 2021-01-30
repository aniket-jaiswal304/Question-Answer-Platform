package com.example.model;

import java.util.List;

public class UserInfo
{
    private int userId;
    private String userName;
    private List<QuestionInfo> questionInfos;
    private List<AnswerInfo> answerInfos;
    private List<CommentInfo> comments;
    private List<QuestionLikeInfo> questionLikeInfos;
    private List<AnswerLikeInfo> answerLikes;

    public UserInfo() {
    }

    public UserInfo(int userId, String userName, List<QuestionInfo> questionInfos, List<AnswerInfo> answerInfos, List<CommentInfo> comments, List<QuestionLikeInfo> questionLikeInfos, List<AnswerLikeInfo> answerLikes) {
        this.userId = userId;
        this.userName = userName;
        this.questionInfos = questionInfos;
        this.answerInfos = answerInfos;
        this.comments = comments;
        this.questionLikeInfos = questionLikeInfos;
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

    public List<QuestionInfo> getQuestions() {
        return questionInfos;
    }

    public void setQuestions(List<QuestionInfo> questionInfos) {
        this.questionInfos = questionInfos;
    }

    public List<AnswerInfo> getAnswers() {
        return answerInfos;
    }

    public void setAnswers(List<AnswerInfo> answerInfos) {
        this.answerInfos = answerInfos;
    }

    public List<CommentInfo> getComments() {
        return comments;
    }

    public void setComments(List<CommentInfo> comments) {
        this.comments = comments;
    }

    public List<QuestionLikeInfo> getQuestionLikes() {
        return questionLikeInfos;
    }

    public void setQuestionLikes(List<QuestionLikeInfo> questionLikeInfos) {
        this.questionLikeInfos = questionLikeInfos;
    }

    public List<AnswerLikeInfo> getAnswerLikes() {
        return answerLikes;
    }

    public void setAnswerLikes(List<AnswerLikeInfo> answerLikes) {
        this.answerLikes = answerLikes;
    }
}
