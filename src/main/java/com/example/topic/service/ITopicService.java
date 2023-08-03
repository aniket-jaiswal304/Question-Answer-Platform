package com.example.topic.service;

import com.example.subtopic.model.Subtopic;
import com.example.topic.model.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ITopicService {
    public List<Topic> retrieveAllTopics();

    public Topic retrieveTopic(int topicId);

    public void deleteTopic(int topicId);

    public int createTopic(Topic topic);

    public void updateTopic(int topicId, Topic topic);
}
