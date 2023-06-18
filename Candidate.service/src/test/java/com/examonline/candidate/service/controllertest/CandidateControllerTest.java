//package com.examonline.candidate.service.controllertest;
//
//import com.examonline.candidate.service.controller.CandidateController;
//import com.examonline.candidate.service.entity.Candidate;
//import com.examonline.candidate.service.service.CandidateService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class CandidateControllerTest {
//    @InjectMocks
//    CandidateController  candidateController;
//    @Mock
//    CandidateService candidateService;
//
//
//    @Test
//    void getAllCandidateTest() {
//        List<Candidate> Candidate = createCandidateMockData();
//        when(candidateService.getAllCandidate()).thenReturn(Candidate);
//
//        List<Candidate> candidateList = candidateController.getALLCandidate().getBody();
//        assert(Candidate.size() == candidateList.size());
//    }
//
//
//
//    @Test
//    void saveBillTest() {
//        Candidate candidate = CandidateMockData();
//        when(candidateService.saveCandidateDetail(candidate)).thenReturn(candidate);
//
//        Candidate candidate1 = candidateController.createCandidate(candidate).getBody();
//        assert(candidate.getCandidateId() == candidate1.getCandidateId());
//
//    }
//
//    @Test
//    void deleteBillTest() {
//        long id = 1;
//        String msg = "Candidate deleted";
//        doNothing().when(candidateService).deleteCandidate(String.valueOf(id));
//        String message = candidateController.deleteCan(String.valueOf(id));
//        assert(message.equals(msg));
//    }
//
//
//    private List<Candidate> createCandidateMockData() {
//        List<Candidate> candidates = new ArrayList<>();
//        Candidate candidate = new Candidate();
//
//
//        candidates.add(candidate);
//        return candidates;
//
//    }
//
//    private Candidate CandidateMockData() {
//        Candidate candidate = new Candidate();
//       candidate.setCandidateId("Unkonwn");
//       candidate.setCandidateEmail("Anmol.1822cs01033@gmail.com");
//       candidate.setCandidateFName("anmol");
//       candidate.setCandidateLName("Varshney");
//
//        return candidate;
//
//    }
//
//
//}
