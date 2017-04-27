//package com.tazuzuapp.api.activity.service;
//
//import com.tazuzuapp.api.user.domain.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@SuppressWarnings("unused")
//@Service
//public class TestDistanceService {
//
//    private final TestDistanceRepository testDistanceRepository;
//
//    @Autowired
//    public TestDistanceService(TestDistanceRepository testDistanceRepository){
//        this.testDistanceRepository = testDistanceRepository;
//    }
//
//    public Boolean exists(Long id) {
//        return testDistanceRepository.exists(id);
//    }
//
//    public TestDistance getTestDistance(Long id) {
//        return testDistanceRepository.getOne(id);
//    }
//
//    public TestDistance createTestDistance(TestDistanceRequest testDistanceRequest) {
//        TestDistance testDistance = new TestDistance(testDistanceRequest);
//        List<Student> students = testDistanceRequest.getParticipantsStudents();
//        for (Student s: students){
//            testDistance.setStudent(s);
//            testDistanceRepository.save(testDistance);
//        }
//
//        return testDistance;
//    }
//
//    public List<TestDistance> getAllTestDistance() {
//        return null;
//    }
//
//    public TestDistance updateTestDistance(Long id, TestDistanceRequest testDistanceRequest) {
//        return null;
//    }
//
//}
