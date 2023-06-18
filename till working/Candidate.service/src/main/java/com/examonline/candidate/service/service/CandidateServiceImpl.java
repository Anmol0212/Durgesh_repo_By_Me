package com.examonline.candidate.service.service;

import com.examonline.candidate.service.entity.Candidate;
import com.examonline.candidate.service.exceptions.ResourceNotFoundException;
import com.examonline.candidate.service.repository.CandidateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CandidateServiceImpl implements CandidateService{
    @Autowired
  private  CandidateRepository candidateRepository;


    @Override
    public Candidate saveCandidateDetail(Candidate candidate) {
        String randomID = UUID.randomUUID().toString();
        candidate.setCandidateId(randomID);
        return candidateRepository.save(candidate);
    }

    @Override
    public List<Candidate> getAllCandidate() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate getCandidateById(String Id) {
        return this.candidateRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Candidate  with the user name not found  !!!"+Id));

    }

//    @Override
//    public Candidate updateCandidate(String id,Candidate candidate) {
//        Candidate candidate1=candidateRepository.save(candidate);
//        return candidate1;
//    }

    @Transactional
    public void updateCandidate( String userId, Candidate updatedUser) {
        Candidate candidate = candidateRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Candidate  with the candidate name not found  !!!"+userId));;
        if (candidate == null) {
            throw new IllegalArgumentException("User not found with id " + userId);
        }

        candidate.setCandidateFName(updatedUser.getCandidateFName());
        candidate.setCandidateLName(updatedUser.getCandidateLName());
        candidate.setCandidateEmail(updatedUser.getCandidateEmail());
        // update other candidate properties as needed

        candidateRepository.save(candidate);
    }

    @Override
    public void deleteCandidate(String id) {
        candidateRepository.deleteById(id);

    }
}
