package com.examonline.candidate.service.service;

import com.examonline.candidate.service.entity.Candidate;

import java.util.List;

public interface CandidateService {
    Candidate saveCandidateDetail(Candidate candidate);
    List<Candidate> getAllCandidate() ;
    Candidate getCandidateById(String Id);
    void updateCandidate(String id,Candidate candidate);

    void  deleteCandidate(String id);
}
