package com.examonline.candidate.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Candidate {
    @Id
    @Column(name = "candidate_ID")
    private String candidateId;
    @Column(name = "candidate_First_Name",length = 15)
    private String candidateFName;
    @Column(name = "candidate_Email")
    private String  candidateEmail;
    @Column(name = "candidate_Last_Name")
    private String candidateLName;
    @Transient
    private List<Question> questions=new ArrayList<>();
    @Transient
    private List<Answers> answers=new ArrayList<>();


}
