package com.answer.Answer.Service.services;

import com.answer.Answer.Service.entity.Answer;
import com.answer.Answer.Service.exception.ResourceNotFoundException;
import com.answer.Answer.Service.repository.AnswerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class AnswerImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Override
    public Answer saveAnswerDetail(Answer answer) {
        String randomID = UUID.randomUUID().toString();
        answer.setAnswerSetId(randomID);
        return answerRepository.save(answer);
    }

    @Override
    public List<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }

    @Override
    public Answer getAnswerById(String Id) {
        return this.answerRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Answer Set  with the user Id not found  !!!"+Id));
    }



    @Transactional
    public void updateAnswer(String userId, Answer updatedUser) {
        Answer answer = answerRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Candidate  with the answer name not found  !!!"+userId));;
        if (answer == null) {
            throw new IllegalArgumentException("User not found with id " + userId);
        }

        answer.setAnswer1(updatedUser.getAnswer1());
        answer.setAnswer2(updatedUser.getAnswer2());
        answer.setAnswer3(updatedUser.getAnswer3());
        // update other answer properties as needed

        answerRepository.save(answer);

    }

    @Override
    public void deleteAnswer(String id) {
        answerRepository.deleteById(id);

    }

    @Override
    public List<Answer> getAnwerByCandidateId(String candidateId) {
        return answerRepository.findByCandidateId(candidateId);
    }

    @Override
    public List<Answer> getAnwerByQuestionId(String questionId) {
        return answerRepository.findByQuestionSetId(questionId);
    }
}
