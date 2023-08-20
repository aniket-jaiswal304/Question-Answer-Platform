package com.example.service;

import com.example.daointerface.TopicDaoI;
import com.example.model.Topic;
import com.example.serviceinterface.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService implements ITopicService {

    @Autowired
    TopicDaoI topicDao;

    @Override
    public List<Topic> getAllTopics()
    {
        return topicDao.findAll();
    }

    @Override
    public Topic getTopic(int topicId)
    {
        Optional<Topic> topicOptional = topicDao.findById(topicId);
        return topicOptional.orElse(null);
    }

    @Override
    public Topic createTopic(Topic topic) {
        return topicDao.save(topic);
    }

    @Override
    public boolean deleteTopic(int topicId) {
        if (topicDao.findById(topicId).isPresent()) {
            topicDao.deleteById(topicId);
            return true;
        }

        return false;
    }

    @Override
    public Topic updateTopic(Topic topic) {
        if (topicDao.findById(topic.getTopicId()).isPresent()) {
            return topicDao.save(topic);
        }

        return null;
    }
}