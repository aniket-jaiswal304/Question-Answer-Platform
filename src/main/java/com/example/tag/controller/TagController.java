package com.example.tag.controller;

import com.example.tag.model.Tags;
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
    public List<Tags> retrieveAllTags()
    {
        return tagService.retrieveAllTags();
    }

    @GetMapping("/tag/{tagId}")
    public Tags retrieveTag(@PathVariable int tagId)
    {
        return tagService.retrieveTag(tagId);
    }

    @DeleteMapping("/tag/{tagId}")
    public void deleteTag(@PathVariable int tagId)
    {
        tagService.deleteTag(tagId);
    }

    @PostMapping("/tag")
    public int createTag(@RequestBody Tags tag)
    {
        return tagService.createTag(tag);
    }

    @PutMapping("/tag/{tagId}")
    public void updateTag(@PathVariable int tagId, @RequestBody Tags tag)
    {
        tagService.updateTag(tagId, tag);
    }

}
