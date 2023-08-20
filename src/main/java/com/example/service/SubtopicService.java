package com.example.service;

import com.example.daointerface.SubtopicDaoI;
import com.example.daointerface.TopicDaoI;
import com.example.model.Subtopic;
import com.example.model.Topic;
import com.example.serviceinterface.ISubtopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubtopicService implements ISubtopicService {
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
