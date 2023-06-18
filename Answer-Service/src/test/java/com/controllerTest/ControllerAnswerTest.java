package com.controllerTest;

import com.answer.Answer.Service.controller.AnswerController;
import com.answer.Answer.Service.entity.Answer;
import com.answer.Answer.Service.services.AnswerService;
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

public class ControllerAnswerTest {




        @InjectMocks
        AnswerController candidateController;
        @Mock
        AnswerService candidateService;


        @Test
        void getAllCandidateTest() {
            List<Answer> Candidate = createCandidateMockData();
            when(candidateService.getAllAnswer()).thenReturn(Candidate);

            List<Answer> candidateList = candidateController.getALLCandidate().getBody();
            assert(Candidate.size() == candidateList.size());
        }



        @Test
        void saveBillTest() {
            Answer candidate = CandidateMockData();
            when(candidateService.saveAnswerDetail(candidate)).thenReturn(candidate);

            Answer candidate1 = candidateController.createCandidate(candidate).getBody();
            assert(candidate.getCandidateId() == candidate1.getAnswerSetId());

        }

        @Test
        void deleteBillTest() {
            long id = 1;
            String msg = "Answer deleted";
            doNothing().when(candidateService).deleteAnswer(String.valueOf(id));
            String message = candidateController.deleteCan(String.valueOf(id));
            assert(message.equals(msg));
        }


        private List<Answer> createCandidateMockData() {
            List<Answer> candidates = new ArrayList<>();
            Answer candidate = new Answer();


            candidates.add(candidate);
            return candidates;

        }

        private Answer CandidateMockData() {
            Answer candidate = new Answer();
       //     candidate.setCandidateId("Unkonwn");
            candidate.setAnswer1("Anmol.1822cs01033@gmail.com");
            candidate.setAnswer2("anmol");
            candidate.setAnswer3("Varshney");

            return candidate;

        }
}
