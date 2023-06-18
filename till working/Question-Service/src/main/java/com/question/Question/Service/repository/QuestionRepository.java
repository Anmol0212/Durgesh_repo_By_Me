package com.question.Question.Service.repository;

import com.question.Question.Service.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,String > {
}
