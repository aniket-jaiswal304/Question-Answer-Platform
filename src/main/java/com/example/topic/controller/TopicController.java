package com.example.topic.controller;

import com.example.model.TopicInfo;
import com.example.topic.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/topic")
public class TopicController {

    @Autowired
    ITopicService topicService;

    @GetMapping("/topic")
    public List<TopicInfo> retrieveAllTopics()
    {
        return topicService.retrieveAllTopics();
    }

    @GetMapping("/topic/{topicId}")
    public TopicInfo retrieveTopic(@PathVariable int topicId)
    {
        return topicService.retrieveTopic(topicId);
    }

    @DeleteMapping("/topic/{topicId}")
    public void deleteTopic(@PathVariable int topicId)
    {
        topicService.deleteTopic(topicId);
    }

    @PostMapping("/topic")
    public int createTopic(@RequestBody TopicInfo topicInfo)
    {
        return topicService.createTopic(topicInfo);
    }

    @PutMapping("/topic/{topicId}")
    public void updateTopic(@PathVariable int topicId, @RequestBody TopicInfo topicInfo)
    {
        topicService.updateTopic(topicId, topicInfo);
    }
}
