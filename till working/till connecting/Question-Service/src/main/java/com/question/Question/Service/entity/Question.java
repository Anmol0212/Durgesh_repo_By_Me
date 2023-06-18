package com.question.Question.Service.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Question {
    @Id
    @Column(name = "Question_SET_Id")
    private String questionSetId;
 private String candidateId;
  @Column(name = "Question_1")
    private String  question1;
    @Column(name = "Question_2")
    private  String question2;
    @Column(name = "Question_3")
    private String question3;
}
