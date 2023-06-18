package com.question.Question.Service.services;

import com.question.Question.Service.QuestionServiceApplication;
import com.question.Question.Service.entity.Question;

import java.util.List;

public interface QuestionService {

    Question saveQuestionDetail(Question candidate);
    List<Question> getAllQuestion() ;
    Question getQuestionById(String Id);
    void updateQuestion(String id,Question candidate);

    void  deleteQuestion(String id);

    List<Question> getQuestionByCandidateId(String candidateId);
 //   List<Question> getQuestionByQuestionId(String questionId);





}
