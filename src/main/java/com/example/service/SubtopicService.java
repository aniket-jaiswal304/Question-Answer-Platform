package com.example.service;

import com.example.dao.SubtopicDaoI;
import com.example.topic.dao.TopicDaoI;
import com.example.entity.Subtopic;
import com.example.topic.model.Topic;
import com.example.model.SubtopicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubtopicService
{
    @Autowired
    SubtopicDaoI subtopicDao;

    @Autowired
    TopicDaoI topicDao;

    public List<SubtopicInfo> retrieveAllSubtopics()
    {
        List<Subtopic> subtopics = subtopicDao.findAll();

        List<SubtopicInfo> subtopicInfoList = new ArrayList<SubtopicInfo>();

        for (Subtopic subtopic : subtopics)
        {
            SubtopicInfo subtopicInfo = new SubtopicInfo(subtopic.getSubtopicId(), subtopic.getsubtopic());
            subtopicInfoList.add(subtopicInfo);
        }
        return subtopicInfoList;
    }

    public SubtopicInfo retrieveSubtopic(int subtopicId)
    {
        Optional<Subtopic> subtopicOptional = subtopicDao.findById(subtopicId);
        Subtopic subtopic = subtopicOptional.get();
        return new SubtopicInfo(subtopic.getSubtopicId(), subtopic.getsubtopic());
    }

    public void deleteSubtopic(int subtopicId)
    {
        subtopicDao.deleteById(subtopicId);
    }

    public int createSubtopic(int topicId, SubtopicInfo subtopicInfo)
    {
        Optional<Topic> topicOptional = topicDao.findById(topicId);
        Topic topic = topicOptional.get();

        Subtopic subtopic = new Subtopic(subtopicInfo.getSubtopicId(), subtopicInfo.getSubtopic());

        subtopic.setTopic(topic);
        subtopicDao.save(subtopic);

        return subtopic.getSubtopicId();
    }

    public void updateSubtopic(int subtopicId, SubtopicInfo subtopicInfo)
    {
        Subtopic subtopic = new Subtopic(subtopicInfo.getSubtopicId(), subtopicInfo.getSubtopic());
        subtopic.setSubtopicId(subtopicId);
        subtopicDao.save(subtopic);
    }
}
