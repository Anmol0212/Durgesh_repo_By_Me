package com.answer.Answer.Service.services;

import com.answer.Answer.Service.entity.Answer;

import java.util.List;

public interface AnswerService {

    Answer saveAnswerDetail(Answer candidate);
    List<Answer> getAllAnswer() ;
    Answer getAnswerById(String Id);
    void updateAnswer(String id, Answer candidate);

    void  deleteAnswer(String id);

    List<Answer> getAnwerByCandidateId(String candidateId);
    List<Answer> getAnwerByQuestionId(String questionId);

}
