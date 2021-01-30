package com.example.model;

import com.example.entity.Subtopic;

import java.util.List;

public class TopicInfo
{
    private int topicId;
    private String topic;
    private List<SubtopicInfo> subtopicInfos;
    private SubtopicInfo subtopicInfo;

    public TopicInfo() {
    }

    public TopicInfo(int topicId, String topic) {
        this.topicId = topicId;
        this.topic = topic;
    }

    public TopicInfo(int topicId, String topic, List<SubtopicInfo> subtopicInfos) {
        this.topicId = topicId;
        this.topic = topic;
        this.subtopicInfos = subtopicInfos;
    }

    public TopicInfo(int topicId, String topic, SubtopicInfo subtopicInfo) {
        this.topicId = topicId;
        this.topic = topic;
        this.subtopicInfo = subtopicInfo;
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

    public List<SubtopicInfo> getSubtopics() {
        return subtopicInfos;
    }

    public void setSubtopics(List<SubtopicInfo> subtopicInfos) {
        this.subtopicInfos = subtopicInfos;
    }

    public SubtopicInfo getSubtopicInfo() {
        return subtopicInfo;
    }

    public void setSubtopic(SubtopicInfo subtopicInfo) {
        this.subtopicInfo = subtopicInfo;
    }
}
