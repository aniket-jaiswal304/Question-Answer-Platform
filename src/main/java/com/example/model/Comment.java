package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Comment {

    @SequenceGenerator(initialValue = 1, sequenceName = "answerCommentSeq", name = "answerCommentSeq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="answerCommentSeq" )
    private int commentId;
    @NotNull
    @Size(min = 50, max = 500, message = "Mandatory. Min length 50 characters, Max length 500")
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    private Answer answer;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public Comment() {
    }

    public Comment(int commentId, String comment, Answer answer, User user) {
        this.commentId = commentId;
        this.comment = comment;
        this.answer = answer;
        this.user = user;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CommentInfo{" +
                "commentID=" + commentId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
