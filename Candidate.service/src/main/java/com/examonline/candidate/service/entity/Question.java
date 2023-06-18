package com.examonline.candidate.service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Question {
    private String questionSet;
    private String candidateId;
    private String answerId;
    private String  question1;
    private  String question2;
    private String question3;
  private Answers answers;


}
