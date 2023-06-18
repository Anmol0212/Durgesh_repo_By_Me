package com.question.Question.Service.controller;

import com.question.Question.Service.entity.Question;
import com.question.Question.Service.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Question-Services")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/")
    public ResponseEntity<Question> createCandidate(@RequestBody Question candidate){
        Question candidate1 = questionService.saveQuestionDetail(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidate1);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Question> getSingleCandidate(@PathVariable("Id") String questionSetId)
    {
        Question candidateById = questionService.getQuestionById(questionSetId);
        return ResponseEntity.ok(candidateById);
    }
    @GetMapping("/")
    public ResponseEntity<List<Question>> getALLCandidate(){
        List<Question> allCandidate = this.questionService.getAllQuestion();
        return ResponseEntity.ok(allCandidate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") String userId, @RequestBody Question updatedUser) {
        try {
           questionService.updateQuestion(userId, updatedUser);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCan(@PathVariable("id") String id){


        questionService.deleteQuestion(id);

        return "QuestionSet deleted";

    }

    @GetMapping("/candidate/{candidateId}")
    public ResponseEntity<List<Question>> getQuestionBycandidateID(@PathVariable("candidateId") String candidateId)
    {
        return  ResponseEntity.ok(questionService.getQuestionByCandidateId(candidateId));
    }


}
