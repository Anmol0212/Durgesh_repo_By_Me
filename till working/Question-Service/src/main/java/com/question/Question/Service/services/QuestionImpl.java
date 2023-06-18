package com.question.Question.Service.services;

import com.question.Question.Service.entity.Question;
import com.question.Question.Service.exception.ResourceNotFoundException;
import com.question.Question.Service.repository.QuestionRepository;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class QuestionImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question saveQuestionDetail(Question question) {
        String randomID = UUID.randomUUID().toString();
        question.setQuestionSetId(randomID);
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(String Id) {
        return this.questionRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Question Set  with the user Id not found  !!!"+Id));
    }



    @Transactional
    public void updateQuestion(String userId, Question updatedUser) {
        Question question = questionRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Candidate  with the question name not found  !!!"+userId));;
        if (question == null) {
            throw new IllegalArgumentException("User not found with id " + userId);
        }

        question.setQuestion1(updatedUser.getQuestion1());
        question.setQuestion2(updatedUser.getQuestion2());
        question.setQuestion3(updatedUser.getQuestion3());
        // update other question properties as needed

        questionRepository.save(question);

    }

    @Override
    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);

    }
}
