package com.example.subtopic.controller;

import com.example.subtopic.model.Subtopic;
import com.example.subtopic.service.ISubtopicService;
import com.example.subtopic.service.SubtopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "subtopic")
public class SubtopicController {

    @Autowired
    ISubtopicService subtopicService;

    @GetMapping("/subtopic")
    public List<Subtopic> retrieveAllSubtopics()
    {
        return subtopicService.retrieveAllSubtopics();
    }

    @GetMapping("/subtopic/{subtopicId}")
    public Subtopic retrieveSubtopic(@PathVariable int subtopicId)
    {
        return subtopicService.retrieveSubtopic(subtopicId);
    }

    @DeleteMapping("/subtopic/{subtopicId}")
    public void deleteSubtopic(@PathVariable int subtopicId)
    {
        subtopicService.deleteSubtopic(subtopicId);
    }

    @PostMapping("/topic/{topicId}/subtopic")
    public int createSubtopic(@PathVariable int topicId, @RequestBody Subtopic subtopic)
    {
        return subtopicService.createSubtopic(topicId, subtopic);
    }

    @PutMapping("subtopic/{subtopicId}")
    public void updateSubtopic(@PathVariable int subtopicId, @RequestBody Subtopic subtopic)
    {
        subtopicService.updateSubtopic(subtopicId, subtopic);
    }
}
