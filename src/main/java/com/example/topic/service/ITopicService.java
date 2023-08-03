package com.example.topic.service;

import com.example.model.SubtopicInfo;
import com.example.model.TopicInfo;
import com.example.subtopic.model.Subtopic;
import com.example.topic.model.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ITopicService {
    public List<TopicInfo> retrieveAllTopics();

    public TopicInfo retrieveTopic(int topicId);

    public void deleteTopic(int topicId);

    public int createTopic(TopicInfo topicInfo);

    public void updateTopic(int topicId, TopicInfo topicInfo);
}
