package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionCompanyMapping {

    @Id
    private int questionId;
    private int companyId;

    public QuestionCompanyMapping() {
    }

    public QuestionCompanyMapping(int questionId, int companyId) {
        this.questionId = questionId;
        this.companyId = companyId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
