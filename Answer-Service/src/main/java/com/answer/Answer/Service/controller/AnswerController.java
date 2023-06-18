package com.answer.Answer.Service.controller;

import com.answer.Answer.Service.entity.Answer;
import com.answer.Answer.Service.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Answer-Service")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping("/")
    public ResponseEntity<Answer> createCandidate(@RequestBody Answer candidate){
        Answer candidate1 = answerService.saveAnswerDetail(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidate1);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Answer> getSingleAnswerSet(@PathVariable("Id") String questionSetId)
    {
        Answer candidateById = answerService.getAnswerById(questionSetId);
        return ResponseEntity.ok(candidateById);
    }
    @GetMapping("/")
    public ResponseEntity<List<Answer>> getALLCandidate(){
        List<Answer> allCandidate = this.answerService.getAllAnswer();
        return ResponseEntity.ok(allCandidate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") String userId, @RequestBody Answer updatedUser) {
        try {
           answerService.updateAnswer(userId, updatedUser);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCan(@PathVariable("id") String id){


        answerService.deleteAnswer(id);

        return "AnswerSet deleted";

    }

    @GetMapping("/candidate/{candidateId}")
    public ResponseEntity<List<Answer>> getAnswerBycandidateID(@PathVariable("candidateId") String candidateId)
    {
        return  ResponseEntity.ok(answerService.getAnwerByCandidateId(candidateId));
    }

     @GetMapping("/questions/{questionId}")
    public ResponseEntity<List<Answer>> getAnswerByquestionID(@PathVariable("questionId") String questionId)
    {
        return ResponseEntity.ok(answerService.getAnwerByQuestionId(questionId));
    }


}
