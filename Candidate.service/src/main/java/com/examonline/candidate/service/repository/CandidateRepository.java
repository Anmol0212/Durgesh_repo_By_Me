package com.examonline.candidate.service.repository;

import com.examonline.candidate.service.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface CandidateRepository extends JpaRepository<Candidate,String> {
}
