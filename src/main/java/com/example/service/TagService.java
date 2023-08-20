package com.example.service;

import com.example.daointerface.ITagsDao;
import com.example.model.Tag;
import com.example.serviceinterface.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService implements ITagService {

    @Autowired
    ITagsDao tagsDao;

    @Override
    public List<Tag> getAllTags() {
        List<Tag> tags;
        tags = tagsDao.findAll();

        return tags;
    }

    @Override
    public Tag getTag(int tagId) {
        Optional<Tag> tagsOptional = tagsDao.findById(tagId);
        return tagsOptional.orElse(null);
    }

    @Override
    public boolean deleteTag(int tagId)
    {
        if(tagsDao.findById(tagId).isPresent()) {
            tagsDao.deleteById(tagId);
            return true;
        }

        return false;
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagsDao.save(tag);
    }

    @Override
    public Tag updateTag(Tag tag) {
        tagsDao.save(tag);
        if(tagsDao.findById(tag.getTagId()).isPresent()) {
            return tagsDao.save(tag);
        }

        return null;
    }
}
