package com.example.service;

import com.example.daointerface.IAnswerCommentsDao;
import com.example.daointerface.ICompanyDao;
import com.example.daointerface.*;
import com.example.entity.*;
import com.example.daointerface.QuestionDaoI;
import com.example.model.Question;
import com.example.daointerface.SubtopicDaoI;
import com.example.model.Subtopic;
import com.example.daointerface.TopicDaoI;
import com.example.daointerface.IUserDao;
import com.example.model.User;
import com.example.serviceinterface.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {

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

    public int createQuestion(int userId, Question question)
    {
        Optional<User> userOptional = userDao.findById(userId);
        User user = userOptional.get();

        Subtopic subtopic = new Subtopic();
        subtopic.setSubtopicId(question.getSubtopicId());
        Optional<Subtopic> subtopicOptional = subtopicDao.findById(subtopic.getSubtopicId());

        /*Question question = new Question(question.getQuestionId(), question.getQuestion(), subtopic, user);
        question = questionDao.save(question);*/

        QuestionCompanyMapping questionCompanyMapping = new QuestionCompanyMapping();
        questionCompanyMapping.setQuestionId(question.getQuestionId());
        questionCompanyMapping.setCompanyId(question.getCompanyId());

        questionCompanyMappingDao.save(questionCompanyMapping);

        QuestionTags questionTags = new QuestionTags();
        questionTags.setQuestionId(question.getQuestionId());
        questionTags.setTag(question.getTag());

        questionTagsDao.save(questionTags);

        return question.getQuestionId();
    }


    public Question getQuestion(int questionId)
    {
        /*Optional<Question> questionOptional = questionDao.findById(questionId);
        Question question = questionOptional.get();


        List<Answer> answerInfoList = new ArrayList<>();
        for (Answer answer : question.getAnswers())
        {

            List<Comment> commentOptional = answerCommentsDao.findAll();
            List<Comment> comments = new ArrayList<Comment>();
            for (Comment comment : commentOptional)
            {
                if (comment.getAnswer().getAnswerId() == answer.getAnswerId())
                {
                    comments.add(comment);
                }
            }

            Long answerLikes = answerLikesDao.count();

            answer.setComments(comments);
            answer.setAnswerLikes(answerLikes);

            answerInfoList.add(answer);
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
        return questionInfo;*/
        return null;
    }
}
