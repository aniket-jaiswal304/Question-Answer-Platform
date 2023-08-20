package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @SequenceGenerator(initialValue = 1, sequenceName = "userSeq", name = "userSeq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="userSeq" )
    @Column(name = "ID")
    private int userId;
    @Column(name = "USERNAME")
    private String userName;

    public User() {
    }

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
