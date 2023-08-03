package com.example.tag.service;

import com.example.tag.model.Tags;

import java.util.List;

public interface ITagService {
    public List<Tags> retrieveAllTags();

    public Tags retrieveTag(int tagId);

    public void deleteTag(int tagId);

    public int createTag(Tags tags);

    public void updateTag(int tagId, Tags tags);
}
