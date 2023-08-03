package com.example.company.model;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="companySeq" )
    @SequenceGenerator(initialValue = 1, sequenceName = "companySeq", name = "companySeq")
    @Column(name = "ID")
    private int companyId;

    @Column(name = "NAME")
    private String companyName;

    public Company() {
    }

    public Company(String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
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