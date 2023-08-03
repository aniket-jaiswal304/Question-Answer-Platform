package com.example.topic.service;

import com.example.topic.dao.TopicDaoI;
import com.example.subtopic.model.Subtopic;
import com.example.topic.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService implements ITopicService {

    @Autowired
    TopicDaoI topicDao;

    public List<Topic> retrieveAllTopics()
    {
        List<Topic> topics = topicDao.findAll();

        List<Topic> topicList = new ArrayList<Topic>();

        for (Topic topic : topics)
        {
            List<Subtopic> subtopicList = new ArrayList<Subtopic>();
            for (Subtopic subtopic : topic.getSubtopics())
            {
                subtopicList.add(subtopic);
            }
            topicList.add(topic);
        }
        return topicList;
    }

    public Topic retrieveTopic(int topicId)
    {
        Optional<Topic> topicOptional = topicDao.findById(topicId);
        Topic topic = topicOptional.get();

        List<Subtopic> subtopicList = new ArrayList<Subtopic>();
        for (Subtopic subtopic : topic.getSubtopics())
        {
            subtopicList.add(subtopic);
        }

        return new Topic(topic.getTopicId(),topic.getTopic(), subtopicList);
    }

    public void deleteTopic(int topicId)
    {
        topicDao.deleteById(topicId);
    }

    public int createTopic(Topic topic)
    {

        topicDao.save(topic);
        return topic.getTopicId();
    }

    public void updateTopic(int topicId, Topic topic)
    {
        topic.setTopicId(topicId);
        topicDao.save(topic);
    }
}