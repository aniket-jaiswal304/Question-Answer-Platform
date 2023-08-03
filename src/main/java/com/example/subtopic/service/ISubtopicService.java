package com.example.subtopic.service;

import com.example.model.SubtopicInfo;
import com.example.subtopic.dao.SubtopicDaoI;
import com.example.subtopic.model.Subtopic;
import com.example.topic.dao.TopicDaoI;
import com.example.topic.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ISubtopicService {

    public List<SubtopicInfo> retrieveAllSubtopics();

    public SubtopicInfo retrieveSubtopic(int subtopicId);

    public void deleteSubtopic(int subtopicId);

    public int createSubtopic(int topicId, SubtopicInfo subtopicInfo);

    public void updateSubtopic(int subtopicId, SubtopicInfo subtopicInfo);
}
