package com.example.tag.service;

import com.example.tag.dao.TagsDaoI;
import com.example.tag.model.Tags;
import com.example.model.TagInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    TagsDaoI tagsDao;

    public List<TagInfo> retrieveAllTags()
    {
        List<Tags> tags = tagsDao.findAll();

        List<TagInfo> tagInfoList = new ArrayList<>();

        for (Tags tag : tags)
        {
            TagInfo tagInfo = new TagInfo(tag.getTagId(), tag.getTag());
            tagInfoList.add(tagInfo);
        }
        return tagInfoList;
    }

    public TagInfo retrieveTag(int tagId)
    {
        Optional<Tags> tagsOptional = tagsDao.findById(tagId);
        Tags tag = tagsOptional.get();
        return new TagInfo(tag.getTagId(), tag.getTag());
    }

    public void deleteTag(int tagId)
    {
        tagsDao.deleteById(tagId);
    }

    public int createTag(TagInfo tagInfo)
    {
        Tags tag = new Tags(tagInfo.getTagId(), tagInfo.getTag());
        tagsDao.save(tag);
        return tag.getTagId();
    }

    public void updateTag(int tagId, TagInfo tagInfo)
    {
        Tags tag = new Tags(tagInfo.getTagId(), tagInfo.getTag());
        tag.setTagId(tagId);
        tagsDao.save(tag);
    }
}
