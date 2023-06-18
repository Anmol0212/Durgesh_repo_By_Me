package com.question.Question.Service.controllerTest;

import com.question.Question.Service.controller.QuestionController;
import com.question.Question.Service.entity.Question;
import com.question.Question.Service.services.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class QuestionControllerTest {



    @ExtendWith(MockitoExtension.class)

        @InjectMocks
    QuestionController candidateController;
        @Mock
        QuestionService candidateService;


        @Test
        void getAllCandidateTest() {
            List<Question> questions = createCandidateMockData();
            when(candidateService.getAllQuestion()).thenReturn(questions);

            List<Question> candidateList = candidateController.getALLCandidate().getBody();
            assert(questions.size() == candidateList.size());
        }



        @Test
        void saveBillTest() {
            Question candidate = CandidateMockData();
            when(candidateService.saveQuestionDetail(candidate)).thenReturn(candidate);

            Question candidate1 = candidateController.createCandidate(candidate).getBody();
            assert(candidate.getQuestionSetId() == candidate1.getQuestionSetId());

        }

        @Test
        void deleteBillTest() {
            long id = 1;
            String msg = "Candidate deleted";
            doNothing().when(candidateService).deleteQuestion(String.valueOf(id));
            String message = candidateController.deleteCan(String.valueOf(id));
            assert(message.equals(msg));
        }


        private List<Question> createCandidateMockData() {
            List<Question> candidates = new ArrayList<>();
            Question candidate = new Question();


            candidates.add(candidate);
            return candidates;

        }

        private Question CandidateMockData() {
            Question candidate = new Question();
           // candidate.setCandidateId("Unkonwn");
            candidate.setQuestion1("explain spring boot");
            candidate.setQuestion2("java version");
            candidate.setQuestion3("sum of two number");

            return candidate;

        }
}
