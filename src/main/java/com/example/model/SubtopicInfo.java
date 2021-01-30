package com.example.model;

public class SubtopicInfo
{
    private int subtopicId;
    private String subtopic;

    public SubtopicInfo() {
    }

    public SubtopicInfo(int subtopicId, String subtopic) {
        this.subtopicId = subtopicId;
        this.subtopic = subtopic;
    }

    public int getSubtopicId() {
        return subtopicId;
    }

    public void setSubtopicId(int subtopicId) {
        this.subtopicId = subtopicId;
    }

    public String getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(String subtopic) {
        this.subtopic = subtopic;
    }
}
