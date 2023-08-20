package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TOPIC")
public class Topic {

    @Id
    @SequenceGenerator(initialValue = 1, sequenceName = "topicSeq", name = "topicSeq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="topicSeq" )
    @Column(name = "ID")
    private int topicId;
    @Column(name = "NAME")
    private String topicName;
    @OneToMany(mappedBy = "topic")
    private List<Subtopic> subtopics;

    public Topic() {
    }

    public Topic(int topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
    }

    public Topic(String topicName, List<Subtopic> subtopics) {
        this.topicName = topicName;
        this.subtopics = subtopics;
    }

    public Topic(int topicId, String topicName, List<Subtopic> subtopics) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.subtopics = subtopics;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<Subtopic> getSubtopics() {
        return subtopics;
    }

    public void setSubtopics(List<Subtopic> subtopics) {
        this.subtopics = subtopics;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                ", subtopics=" + subtopics +
                '}';
    }
}
