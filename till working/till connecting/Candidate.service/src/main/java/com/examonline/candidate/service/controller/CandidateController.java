package com.examonline.candidate.service.controller;

import com.examonline.candidate.service.entity.Candidate;
import com.examonline.candidate.service.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CandidateService")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @PostMapping("/")
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate){
        Candidate candidate1 = candidateService.saveCandidateDetail(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidate1);
    }
    @GetMapping("/{candidateId}")
    public ResponseEntity<Candidate> getSingleCandidate(@PathVariable String candidateId)
    {
        Candidate candidateById = candidateService.getCandidateById(candidateId);
        return ResponseEntity.ok(candidateById);
    }
    @GetMapping("/")
    public ResponseEntity<List<Candidate>> getALLCandidate(){
        List<Candidate> allCandidate = this.candidateService.getAllCandidate();
        return ResponseEntity.ok(allCandidate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") String userId, @RequestBody Candidate updatedUser) {
        try {
            candidateService.updateCandidate(userId, updatedUser);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCan(@PathVariable("id") String id){


        candidateService.deleteCandidate(id);

        return "Candidate deleted";

    }





}