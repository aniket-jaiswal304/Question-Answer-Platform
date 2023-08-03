package com.example.tag.controller;

import com.example.model.TagInfo;
import com.example.tag.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tag")
public class TagController {


    @Autowired
    ITagService tagService;

    @GetMapping("/tag")
    public List<TagInfo> retrieveAllTags()
    {
        return tagService.retrieveAllTags();
    }

    @GetMapping("/tag/{tagId}")
    public TagInfo retrieveTag(@PathVariable int tagId)
    {
        return tagService.retrieveTag(tagId);
    }

    @DeleteMapping("/tag/{tagId}")
    public void deleteTag(@PathVariable int tagId)
    {
        tagService.deleteTag(tagId);
    }

    @PostMapping("/tag")
    public int createTag(@RequestBody TagInfo tag)
    {
        return tagService.createTag(tag);
    }

    @PutMapping("/tag/{tagId}")
    public void updateTag(@PathVariable int tagId, @RequestBody TagInfo tag)
    {
        tagService.updateTag(tagId, tag);
    }

}
