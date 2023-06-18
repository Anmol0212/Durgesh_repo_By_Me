package com.answer.Answer.Service.repository;

import com.answer.Answer.Service.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,String > {


    //customfinder method

    List<Answer> findByCandidateId(String candidateId);
    List<Answer> findByQuestionSetId(String questionSetId);
}
