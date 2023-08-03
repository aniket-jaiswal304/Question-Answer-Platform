package com.example.tag.service;

import com.example.model.TagInfo;
import java.util.List;

public interface ITagService {
    public List<TagInfo> retrieveAllTags();

    public TagInfo retrieveTag(int tagId);

    public void deleteTag(int tagId);

    public int createTag(TagInfo tagInfo);

    public void updateTag(int tagId, TagInfo tagInfo);
}
