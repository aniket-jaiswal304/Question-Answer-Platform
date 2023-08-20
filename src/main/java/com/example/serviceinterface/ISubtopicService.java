package com.example.serviceinterface;

import com.example.model.Subtopic;

import java.util.List;

public interface ISubtopicService {

    public List<Subtopic> retrieveAllSubtopics();

    public Subtopic retrieveSubtopic(int subtopicId);

    public void deleteSubtopic(int subtopicId);

    public int createSubtopic(int topicId, Subtopic subtopic);

    public void updateSubtopic(int subtopicId, Subtopic subtopic);
}
