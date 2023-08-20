package com.example.model;

import com.example.entity.QuestionLikes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity

@Table(name = "QUESTION")
public class Question {

    @SequenceGenerator(initialValue = 1, sequenceName = "questionSeq", name = "questionSeq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="questionSeq" )
    @Column(name = "ID")
    private int questionId;
    @Column(name = "QUESTION")
    @NotNull
    @Size(min = 50, max = 500, message = "Mandatory. Min length 50 characters, Max length 500")
    private String question;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToMany(mappedBy = "question")
    private List<QuestionLikes> questionLikes;
    @ManyToOne(fetch = FetchType.LAZY)
    private Subtopic subtopic;
    @Transient
    private int subtopicId;
    @Transient
    private int companyId;
    @Transient
    private String tag;

    public Question() {
    }

    public Question(int questionId, String question, Subtopic subtopic, User user) {
        this.questionId = questionId;
        this.question = question;
        this.subtopic = subtopic;
        this.user = user;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<QuestionLikes> getQuestionLikes() {
        return questionLikes;
    }

    public void setQuestionLikes(List<QuestionLikes> questionLikes) {
        this.questionLikes = questionLikes;
    }

    public Subtopic getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(Subtopic subtopic) {
        this.subtopic = subtopic;
    }

    public int getSubtopicId() {
        return subtopicId;
    }

    public void setSubtopicId(int subtopicId) {
        this.subtopicId = subtopicId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                ", user=" + user +
                ", questionLikes=" + questionLikes +
                ", subtopic=" + subtopic +
                ", subtopicId=" + subtopicId +
                ", companyId=" + companyId +
                ", tag='" + tag + '\'' +
                '}';
    }
}
