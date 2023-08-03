package com.example.tag.service;

import com.example.tag.dao.ITagsDao;
import com.example.tag.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagService implements ITagService {

    @Autowired
    ITagsDao tagsDao;

    public List<Tags> retrieveAllTags()
    {
        List<Tags> tags = tagsDao.findAll();


        return tags;
    }

    public Tags retrieveTag(int tagId)
    {
        Optional<Tags> tagsOptional = tagsDao.findById(tagId);
        Tags tag = tagsOptional.get();
        return tag;
    }

    public void deleteTag(int tagId)
    {
        tagsDao.deleteById(tagId);
    }

    public int createTag(Tags tag)
    {
        tagsDao.save(tag);
        return tag.getTagId();
    }

    public void updateTag(int tagId, Tags tag)
    {
        tagsDao.save(tag);
    }
}
