package com.example.controller;

import com.example.model.Tag;
import com.example.serviceinterface.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    ITagService tagService;

    @GetMapping("/get-tags")
    public ResponseEntity<List<Tag>> getAllTags() {
        return ResponseEntity.ok().body(tagService.getAllTags());
    }

    @GetMapping("/get-tag/{tagId}")
    public ResponseEntity<Tag> getTag(@PathVariable int tagId) {
        if(tagId <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Tag tag = tagService.getTag(tagId);

        return ResponseEntity.ok().body(tag);
    }


    @PostMapping("/create-tag")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return ResponseEntity.ok().body(tagService.createTag(tag));
    }

    @DeleteMapping("/delete-tag/{tagId}")
    public ResponseEntity<String> deleteTag(@PathVariable int tagId) {
        if(tagId <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if(tagService.deleteTag(tagId))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update-tag")
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag) {
        if(tag.getTagId() <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        tag = tagService.updateTag(tag);

        if(tag != null)
            return ResponseEntity.ok().body(tag);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
