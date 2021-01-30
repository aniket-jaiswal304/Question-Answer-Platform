package com.example.model;

import java.util.List;

public class QuestionInfo
{
    private int questionId;
    private String question;
    private int companyId;
    private int subtopicId;
    private Long questionLikes;
    private String tag;
    private List<AnswerInfo> answerInfoList;
    private CompanyInfo companyInfo;
    private List<TagInfo> tagInfoList;
    private TopicInfo topicInfo;

    public QuestionInfo() {
    }

    public QuestionInfo(int questionId, String question, int companyId, int subtopicId, String tag) {
        this.questionId = questionId;
        this.question = question;
        this.companyId = companyId;
        this.subtopicId = subtopicId;
        this.tag = tag;
    }

    public QuestionInfo(int questionId, String question, Long questionLikes, List<AnswerInfo> answerInfoList, CompanyInfo companyInfo, String tag, TopicInfo topicInfo) {
        this.questionId = questionId;
        this.question = question;
        this.questionLikes = questionLikes;
        this.answerInfoList = answerInfoList;
        this.companyInfo = companyInfo;
        this.tag = tag;
        this.topicInfo = topicInfo;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getSubtopicId() {
        return subtopicId;
    }

    public void setSubtopicId(int subtopicId) {
        this.subtopicId = subtopicId;
    }

    public Long getQuestionLikes() {
        return questionLikes;
    }

    public void setQuestionLikes(Long questionLikes) {
        this.questionLikes = questionLikes;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<AnswerInfo> getAnswerInfoList() {
        return answerInfoList;
    }

    public void setAnswerInfoList(List<AnswerInfo> answerInfoList) {
        this.answerInfoList = answerInfoList;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public List<TagInfo> getTagInfoList() {
        return tagInfoList;
    }

    public void setTagInfoList(List<TagInfo> tagInfoList) {
        this.tagInfoList = tagInfoList;
    }

    public TopicInfo getTopicInfo() {
        return topicInfo;
    }

    public void setTopicInfo(TopicInfo topicInfo) {
        this.topicInfo = topicInfo;
    }

    @Override
    public String toString() {
        return "QuestionInfo{" +
                "question='" + question + '\'' +
                ", companyId=" + companyId +
                ", subtopicId=" + subtopicId +
                ", questionLikes=" + questionLikes +
                ", tag='" + tag + '\'' +
                ", answerInfoList=" + answerInfoList +
                '}';
    }
}
