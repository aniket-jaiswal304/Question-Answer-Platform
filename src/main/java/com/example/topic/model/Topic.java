package com.example.topic.model;

import com.example.subtopic.model.Subtopic;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic {

    @SequenceGenerator(initialValue = 1, sequenceName = "topicSeq", name = "topicSeq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="topicSeq" )
    private int topicId;
    private String topic;
    @OneToMany(mappedBy = "topic")
    private List<Subtopic> subtopics;

    public Topic() {
    }

    public Topic(int topicId, String topic) {
        this.topicId = topicId;
        this.topic = topic;
    }

    public Topic(int topicId, String topic, List<Subtopic> subtopics) {
        this.topicId = topicId;
        this.topic = topic;
        this.subtopics = subtopics;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Subtopic> getSubtopics() {
        return subtopics;
    }

    public void setSubtopics(List<Subtopic> subtopics) {
        this.subtopics = subtopics;
    }

    @Override
    public String toString() {
        return "TopicInfo{" +
                "topicId=" + topicId +
                ", topic='" + topic + '\'' +
                '}';
    }
}
