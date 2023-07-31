package com.example.company.model;

import javax.persistence.*;

@Entity
public class Company
{
    @SequenceGenerator(initialValue = 1, sequenceName = "companySeq", name = "companySeq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="companySeq" )
    private int companyId;
    private String companyName;

    public Company() {
    }

    public Company(int companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}