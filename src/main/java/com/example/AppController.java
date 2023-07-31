package com.example;

import com.example.company.service.CompanyService;
import com.example.model.*;
import com.example.service.*;
import com.example.tag.service.TagService;
import com.example.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @Autowired
    AnswerCommentService answerCommentService;

    @Autowired
    QuestionLikeService questionLikeService;

    @Autowired
    AnswerLikeService answerLikeService;

    @Autowired
    TopicService topicService;

    @Autowired
    SubtopicService subtopicService;

    @Autowired
    TagService tagService;

    @Autowired
    QuestionTagService questionTagService;

    @Autowired
    QuestionCompanyMappingService questionCompanyMappingService;

    //Company CRUD Operations
    @GetMapping("/company")
    public List<CompanyInfo> retrieveAllCompanies()
    {
        return companyService.retrieveAllCompanies();
    }

    @GetMapping("/company/{companyId}")
    public CompanyInfo retrieveCompany(@PathVariable int companyId)
    {
        return companyService.retrieveCompany(companyId);
    }

    @DeleteMapping("/company/{companyId}")
    public void deleteCompany(@PathVariable int companyId)
    {
        companyService.deleteCompany(companyId);
    }

    @PostMapping("/company")
    public int createCompany(@RequestBody CompanyInfo companyInfo)
    {
        return companyService.createCompany(companyInfo);
    }

    @PutMapping("/company/{companyId}")
    public void updateCompany(@PathVariable int companyId, @RequestBody CompanyInfo companyInfo)
    {
        companyService.updateCompany(companyId, companyInfo);
    }


    //Topic CRUD Operations
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


    //Subtopic CRUD Operations
    @GetMapping("/subtopic")
    public List<SubtopicInfo> retrieveAllSubtopics()
    {
        return subtopicService.retrieveAllSubtopics();
    }

    @GetMapping("/subtopic/{subtopicId}")
    public SubtopicInfo retrieveSubtopic(@PathVariable int subtopicId)
    {
        return subtopicService.retrieveSubtopic(subtopicId);
    }

    @DeleteMapping("/subtopic/{subtopicId}")
    public void deleteSubtopic(@PathVariable int subtopicId)
    {
        subtopicService.deleteSubtopic(subtopicId);
    }

    @PostMapping("/topic/{topicId}/subtopic")
    public int createSubtopic(@PathVariable int topicId, @RequestBody SubtopicInfo subtopicInfo)
    {
        return subtopicService.createSubtopic(topicId, subtopicInfo);
    }

    @PutMapping("subtopic/{subtopicId}")
    public void updateSubtopic(@PathVariable int subtopicId, @RequestBody SubtopicInfo subtopicInfo)
    {
        subtopicService.updateSubtopic(subtopicId, subtopicInfo);
    }


    //Tag CRUD Operations
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


    //POST Questions
    @PostMapping("/users/{userId}/questions")
    public int createQuestion(@PathVariable int userId, @RequestBody QuestionInfo questionInfo)
    {
        return questionService.createQuestion(userId, questionInfo);
    }


    //POST Answers
    @PostMapping("/users/{userId}/questions/{questionId}/answers")
    public int createAnswer(@PathVariable int userId, @PathVariable int questionId, @RequestBody AnswerInfo answerInfo)
    {
        return answerService.createAnswer(userId, questionId, answerInfo);
    }


    //POST Comments
    @PostMapping("/users/{userId}/answers/{answerId}/comments")
    public int createComment(@PathVariable int userId, @PathVariable int answerId, @RequestBody CommentInfo commentInfo)
    {
        return answerCommentService.createComment(userId, answerId, commentInfo);
    }


    //POST QuestionInfo Likes
    @PostMapping("/users/{userId}/questions/{questionId}/questionLike")
    public void createQuestionLike(@PathVariable int userId, @PathVariable int questionId)
    {
        questionLikeService.createQuestionLike(userId, questionId);
    }


    //POST AnswerInfo Likes
    @PostMapping("/users/{userId}/answers/{answerId}/answerLike")
    public void createAnswerLike(@PathVariable int userId, @PathVariable int answerId)
    {
        answerLikeService.createAnswerLike(userId, answerId);
    }


    //GET QuestionInfo
    @GetMapping("/question/{questionId}")
    public QuestionInfo getQuestion(@PathVariable int questionId)
    {
        return questionService.getQuestion(questionId);
    }
}
