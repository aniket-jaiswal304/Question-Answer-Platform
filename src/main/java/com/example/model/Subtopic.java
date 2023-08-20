package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUBTOPIC")
public class Subtopic {

    @Id
    @SequenceGenerator(initialValue = 1, sequenceName = "subtopicSeq", name = "subtopicSeq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="subtopicSeq" )
    @Column(name = "ID")
    private int subtopicId;
    @Column(name = "NAME")
    private String subtopicName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;

    public Subtopic() {
    }

    public Subtopic(String subtopicName) {
        this.subtopicName = subtopicName;
    }

    public Subtopic(int subtopicId, String subtopic) {
        this.subtopicId = subtopicId;
        this.subtopicName = subtopic;
    }

    public int getSubtopicId() {
        return subtopicId;
    }

    public void setSubtopicId(int subtopicId) {
        this.subtopicId = subtopicId;
    }

    public String getsubtopic() {
        return subtopicName;
    }

    public void setsubtopic(String subtopic) {
        this.subtopicName = subtopic;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "SubtopicInfo{" +
                "subTopicId=" + subtopicId +
                ", subTopic='" + subtopicName + '\'' +
                '}';
    }
}
