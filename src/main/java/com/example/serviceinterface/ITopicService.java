package com.example.serviceinterface;

import com.example.model.Topic;

import java.util.List;

public interface ITopicService {
    public List<Topic> getAllTopics();

    public Topic getTopic(int topicId);

    public Topic createTopic(Topic topic);

    public boolean deleteTopic(int topicId);

    public Topic updateTopic(Topic topic);
}
