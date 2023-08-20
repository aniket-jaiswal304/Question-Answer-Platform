package com.example.serviceinterface;

import com.example.model.Tag;

import java.util.List;

public interface ITagService {
    public List<Tag> getAllTags();

    public Tag getTag(int tagId);

    public boolean deleteTag(int tagId);

    public Tag createTag(Tag tags);

    public Tag updateTag(Tag tags);
}
