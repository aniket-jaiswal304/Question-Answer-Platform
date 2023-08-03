package com.example.subtopic.service;

import com.example.subtopic.dao.SubtopicDaoI;
import com.example.subtopic.model.Subtopic;
import com.example.topic.dao.TopicDaoI;
import com.example.topic.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ISubtopicService {

    public List<Subtopic> retrieveAllSubtopics();

    public Subtopic retrieveSubtopic(int subtopicId);

    public void deleteSubtopic(int subtopicId);

    public int createSubtopic(int topicId, Subtopic subtopic);

    public void updateSubtopic(int subtopicId, Subtopic subtopic);
}
