package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subtopic {

    @SequenceGenerator(initialValue = 1, sequenceName = "subtopicSeq", name = "subtopicSeq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="subtopicSeq" )
    private int subtopicId;
    private String subtopic;
    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;
    @OneToMany(mappedBy = "subtopic")
    private List<Question> questions;

    public Subtopic() {
    }

    public Subtopic(int subtopicId, String subtopic) {
        this.subtopicId = subtopicId;
        this.subtopic = subtopic;
    }

    public int getSubtopicId() {
        return subtopicId;
    }

    public void setSubtopicId(int subtopicId) {
        this.subtopicId = subtopicId;
    }

    public String getsubtopic() {
        return subtopic;
    }

    public void setsubtopic(String subtopic) {
        this.subtopic = subtopic;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "SubtopicInfo{" +
                "subTopicId=" + subtopicId +
                ", subTopic='" + subtopic + '\'' +
                '}';
    }
}
