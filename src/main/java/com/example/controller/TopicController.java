package com.example.controller;

import com.example.model.Topic;
import com.example.serviceinterface.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/topic")
public class TopicController {

    @Autowired
    ITopicService topicService;

    @GetMapping(value = "/topic")
    public ResponseEntity<List<Topic>> getAllTopics() {
        return ResponseEntity.ok().body(topicService.getAllTopics());
    }

    @GetMapping(value = "/topic/{topicId}")
    public ResponseEntity<Topic> getTopic(@PathVariable int topicId) {
        if(topicId <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok().body(topicService.getTopic(topicId));
    }

    @PostMapping("value = /topic")
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        return ResponseEntity.ok().body(topicService.createTopic(topic));
    }

    @DeleteMapping(value = "/topic/{topicId}")
    public ResponseEntity<String> deleteTopic(@PathVariable int topicId) {
        ;
        if(topicId <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if(topicService.deleteTopic(topicId))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/topic/{topicId}")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic)
    {
        if(topic.getTopicId() <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        topic = topicService.updateTopic(topic);
        if(topic != null)
            return ResponseEntity.ok().body(topic);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
