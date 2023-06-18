package com.examonline.candidate.service.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Answers {

    private String answerSetId;

    private String  answer1;

    private  String answer2;

    private String answer3;
}
