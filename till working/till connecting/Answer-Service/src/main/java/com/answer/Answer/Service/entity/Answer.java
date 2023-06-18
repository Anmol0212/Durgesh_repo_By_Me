package com.answer.Answer.Service.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Answer {
    @Id
    @Column(name = "answer_SET_Id")
    private String answerSetId;
    private String candidateId;
    private String questionSetId;
  @Column(name = "answer_1")
    private String  answer1;
    @Column(name = "answer_2")
    private  String answer2;
    @Column(name = "answer_3")
    private String answer3;
}
