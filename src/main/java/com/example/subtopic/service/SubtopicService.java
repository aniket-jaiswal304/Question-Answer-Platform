package com.example.subtopic.service;

import com.example.subtopic.dao.SubtopicDaoI;
import com.example.topic.dao.TopicDaoI;
import com.example.subtopic.model.Subtopic;
import com.example.topic.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubtopicService implements ISubtopicService  {
    @Autowired
    SubtopicDaoI subtopicDao;

    @Autowired
    TopicDaoI topicDao;

    public List<Subtopic> retrieveAllSubtopics()
    {
        List<Subtopic> subtopics = subtopicDao.findAll();

        return subtopics;
    }

    public Subtopic retrieveSubtopic(int subtopicId)
    {
        Optional<Subtopic> subtopicOptional = subtopicDao.findById(subtopicId);
        Subtopic subtopic = subtopicOptional.get();
        return subtopic;
    }

    public void deleteSubtopic(int subtopicId)
    {
        subtopicDao.deleteById(subtopicId);
    }

    public int createSubtopic(int topicId, Subtopic subtopic)
    {
        Optional<Topic> topicOptional = topicDao.findById(topicId);
        Topic topic = topicOptional.get();

        subtopic.setTopic(topic);
        subtopicDao.save(subtopic);

        return subtopic.getSubtopicId();
    }

    public void updateSubtopic(int subtopicId, Subtopic subtopic)
    {
        subtopic.setSubtopicId(subtopicId);
        subtopicDao.save(subtopic);
    }
}
