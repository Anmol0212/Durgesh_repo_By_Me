package com.question.Question.Service.repository;

import com.question.Question.Service.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,String > {
    List<Question> findByCandidateId(String candidateId);
}
