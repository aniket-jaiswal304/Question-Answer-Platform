This Project is Based on backend APIs for a question answer platform, where questions and answers for interviews of various companies are being captured

ENTITIES

This platform would has the following entities, with following relationship among them.
1. Question - Core entity of the platform
2. Company - A company for which question was asked, Eg: Amazon/Microsoft
3. Topic - Topic for which a question was being asked eg: Data Structures, Algorithms
 a. Subtopic - A topic can have various subtopics. Eg: For topic Data Structures, it can have subtopics like Stacks, Queues, Lists etc.
5. Answer - A questions can have multiple answers
6. Answer_comments - Users can comment on answers, hence an answer can have multiple comments
7. Question_likes - User have like a question
8. Question_company_mapping - A question can be asked for many companies. For example, the same question may be asked by Amazon and Microsoft. To capture this information, we      need to have this entity.
9. Answer_likes - Users may like an answer to a question. This data would be captured in this table.
10. Tags - Not all information can be captured using topics and subtopics. For example while subtopics can be Stacks, Queues and Lists, master list of tags may contain              complexities of algorithms which could be O(n), O(logn) etc.
11. Question_tags - A Question can be associated with multiple tags. This table will contain that information
12. User - User who is posting question/answer/likes etc.

APIs

For scope of this Project, I have build the following APIs
1. CRUD APIs for all master data, which includes following entities/tables
 a. Company
 b. Topics
 c. Subtopics
 d. Tags

2. /POST Questions
 a. Input
  i. Question Text - Mandatory. Min length 50 characters, Max length 500 characters
  ii. CompanyId - Optional
  iii. SubtopicId - Mandatory
  iv. Tags - List of tags - Optional
  v. User ID - the Id of user submitting the question
 b. Output
  i. ID - ID of question saved in database

3. /POST Answers
 a. Input
  i. Question ID - Question for which answer is being submitted
  ii. Answer Text - Mandatory. Min length 50 characters, Max length 500 characters
  iii. User ID- the ID of user submitting answer
 b. Output
  i. ID - ID of answer saved in database

4. /POST Comments (Post comments for a given answer)
 a. Input
  i. Answer ID - Answer for which comment is being posted - Mandatory
  ii. UserID - User posting the answer - Mandatory
  iii. Comment Text - Comment Text - Mandatory. Min length 50 characters, Max length 500 characters
 b. Output
  i. ID - ID of comment saved in database

5. /POST Question_likes (For a user to like a given question)
 a. Input
  i. QuestionID - Question which is being liked
  ii. UserId - ID of user liking the question

6. /POST Answer_likes (For a user liking the given answer)
 a. Input
  i. AnswerID - Answer which is being liked
  ii. UserId - ID of user liking the answer

7. /GET Filter_Questions - Returns list of questions based on the combination of following query parameters
 a. Input
  i. Companies - List of companies - Optional
  ii. Subtopics - List of subtopics - Optional
  iii. Likes - Questions with more votes than votes sent as input - Optional
  iv. Date - Questions asked after a given date - Optional
  v. Tags - List of tags - - Optional
 b. Output
  i. Question ID
  ii. Question Text
  iii. Companies - List of companies for which the question was asked
  iv. Likes - Number of likes of the question
  v. Answer - Answer with most likes for the given question
  vi. Tags - Tags associated with the given question

8. /GET Question - Get following details of a question for a given question id
 a. Question Text
 b. List of answers for the given question with following details
  i. Answer text
  ii. User Id of user who answered the question
  iii. Number of likes for the answer
  iv. List of comments of the answer, along with date and user who made the comment
 c. Number of likes that the question has
 d. Companies for which the question was asked
 e. Tags for the question
 f. Topics for the question

Technology Used
1. Java
2. Spring Boot
3. JPA
4. Maven
5. Oracle DB
