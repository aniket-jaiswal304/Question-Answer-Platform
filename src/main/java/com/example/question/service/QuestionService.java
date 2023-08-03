package com.example.question.service;

import com.example.answer.model.Answer;
import com.example.comment.dao.IAnswerCommentsDao;
import com.example.comment.model.Comment;
import com.example.company.dao.ICompanyDao;
import com.example.company.model.Company;
import com.example.dao.*;
import com.example.entity.*;
import com.example.model.*;
import com.example.question.dao.QuestionDaoI;
import com.example.question.model.Question;
import com.example.subtopic.dao.SubtopicDaoI;
import com.example.subtopic.model.Subtopic;
import com.example.topic.dao.TopicDaoI;
import com.example.topic.model.Topic;
import com.example.user.dao.IUserDao;
import com.example.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDaoI questionDao;

    @Autowired
    IUserDao userDao;

    @Autowired
    SubtopicDaoI subtopicDao;

    @Autowired
    QuestionCompanyMappingDaoI questionCompanyMappingDao;

    @Autowired
    QuestionTagsDaoI questionTagsDao;

    @Autowired
    QuestionLikesDaoI questionLikesDao;

    @Autowired
    ICompanyDao companyDao;

    @Autowired
    TopicDaoI topicDao;

    @Autowired
    IAnswerCommentsDao answerCommentsDao;

    @Autowired
    AnswerLikesDaoI answerLikesDao;

    public int createQuestion(int userId, QuestionInfo questionInfo)
    {
        Optional<User> userOptional = userDao.findById(userId);
        User user = userOptional.get();

        Subtopic subtopic = new Subtopic();
        subtopic.setSubtopicId(questionInfo.getSubtopicId());
        Optional<Subtopic> subtopicOptional = subtopicDao.findById(subtopic.getSubtopicId());

        Question question = new Question(questionInfo.getQuestionId(), questionInfo.getQuestion(), subtopic, user);
        question = questionDao.save(question);

        QuestionCompanyMapping questionCompanyMapping = new QuestionCompanyMapping();
        questionCompanyMapping.setQuestionId(question.getQuestionId());
        questionCompanyMapping.setCompanyId(questionInfo.getCompanyId());

        questionCompanyMappingDao.save(questionCompanyMapping);

        QuestionTags questionTags = new QuestionTags();
        questionTags.setQuestionId(question.getQuestionId());
        questionTags.setTag(questionInfo.getTag());

        questionTagsDao.save(questionTags);

        return question.getQuestionId();
    }


    public QuestionInfo getQuestion(int questionId)
    {
        Optional<Question> questionOptional = questionDao.findById(questionId);
        Question question = questionOptional.get();


        List<AnswerInfo> answerInfoList = new ArrayList<AnswerInfo>();
        for (Answer answer : question.getAnswers())
        {

            AnswerInfo answerInfo = new AnswerInfo(answer.getAnswerId(), answer.getAnswer());

            List<Comment> commentOptional = answerCommentsDao.findAll();
            List<CommentInfo> comments = new ArrayList<CommentInfo>();
            for (Comment comment : commentOptional)
            {
                if (comment.getAnswer().getAnswerId() == answerInfo.getAnswerId())
                {
                    CommentInfo commentInfo = new CommentInfo(comment.getCommentId(), comment.getComment());
                    comments.add(commentInfo);
                }
            }

            Long answerLikes = answerLikesDao.count();

            answerInfo.setComments(comments);
            answerInfo.setAnswerLikes(answerLikes);

            answerInfoList.add(answerInfo);
        }

        Long questionLikes = questionLikesDao.count();

        Optional<QuestionCompanyMapping> questionCompanyMappingOptional = questionCompanyMappingDao.findById(questionId);
        QuestionCompanyMapping questionCompanyMapping = questionCompanyMappingOptional.get();

        Optional<Company> companyOptional = companyDao.findById(questionCompanyMapping.getCompanyId());
        Company company = companyOptional.get();
        CompanyInfo companyInfo = new CompanyInfo(company.getCompanyId(), company.getCompanyName());

        Optional<QuestionTags> questionTagsOptional = questionTagsDao.findById(questionId);
        QuestionTags questionTags = questionTagsOptional.get();

        Optional<Subtopic> subtopicOptional = subtopicDao.findById(question.getSubtopic().getSubtopicId());
        Subtopic subtopic = subtopicOptional.get();
        Optional<Topic> topicOptional = topicDao.findById(subtopic.getTopic().getTopicId());
        Topic topic = topicOptional.get();
        SubtopicInfo subtopicInfo = new SubtopicInfo(subtopic.getSubtopicId(), subtopic.getsubtopic());
        TopicInfo topicInfo = new TopicInfo(topic.getTopicId(), topic.getTopic(), subtopicInfo);

        QuestionInfo questionInfo = new QuestionInfo(questionId, question.getQuestion(),questionLikes, answerInfoList, companyInfo, questionTags.getTag(), topicInfo);
        return questionInfo;
    }
}
