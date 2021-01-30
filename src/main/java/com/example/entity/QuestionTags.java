package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionTags {

    @Id
    private int questionId;
    private String tag;

    public QuestionTags() {
    }

    public QuestionTags(int questionId, String  tag) {
        this.questionId = questionId;
        this.tag = tag;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String  getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
