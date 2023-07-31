package com.example.topic.service;

import com.example.topic.dao.TopicDaoI;
import com.example.entity.Subtopic;
import com.example.topic.model.Topic;
import com.example.model.SubtopicInfo;
import com.example.model.TopicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    TopicDaoI topicDao;

    public List<TopicInfo> retrieveAllTopics()
    {
        List<Topic> topics = topicDao.findAll();

        List<TopicInfo> topicInfoList = new ArrayList<TopicInfo>();

        for (Topic topic : topics)
        {
            List<SubtopicInfo> subtopicInfoList = new ArrayList<SubtopicInfo>();
            for (Subtopic subtopic : topic.getSubtopics())
            {
                SubtopicInfo subtopicInfo = new SubtopicInfo(subtopic.getSubtopicId(), subtopic.getsubtopic());
                subtopicInfoList.add(subtopicInfo);
            }
            TopicInfo topicInfo = new TopicInfo(topic.getTopicId(),topic.getTopic(), subtopicInfoList);
            topicInfoList.add(topicInfo);
        }
        return topicInfoList;
    }

    public TopicInfo retrieveTopic(int topicId)
    {
        Optional<Topic> topicOptional = topicDao.findById(topicId);
        Topic topic = topicOptional.get();

        List<SubtopicInfo> subtopicInfoList = new ArrayList<SubtopicInfo>();
        for (Subtopic subtopic : topic.getSubtopics())
        {
            SubtopicInfo subtopicInfo = new SubtopicInfo(subtopic.getSubtopicId(), subtopic.getsubtopic());
            subtopicInfoList.add(subtopicInfo);
        }

        return new TopicInfo(topic.getTopicId(),topic.getTopic(), subtopicInfoList);
    }

    public void deleteTopic(int topicId)
    {
        topicDao.deleteById(topicId);
    }

    public int createTopic(TopicInfo topicInfo)
    {
        Topic topic = new Topic(topicInfo.getTopicId(),topicInfo.getTopic());

        topicDao.save(topic);
        return topic.getTopicId();
    }

    public void updateTopic(int topicId, TopicInfo topicInfo)
    {
        Topic topic = new Topic(topicId, topicInfo.getTopic());
        topic.setTopicId(topicId);
        topicDao.save(topic);
    }
}