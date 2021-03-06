package com.tazuzuapp.api.activity.service;

import com.tazuzuapp.api.activity.domain.ActivityInstance;
import com.tazuzuapp.api.activity.domain.ActivityInstanceMeasurement;
import com.tazuzuapp.api.activity.domain.ActivityInstanceRequest;
import com.tazuzuapp.api.activity.repository.ActivityInstanceMeasurementRepository;
import com.tazuzuapp.api.activity.repository.ActivityInstanceRepository;
import com.tazuzuapp.api.activity.repository.ActivityTypeRepository;
import com.tazuzuapp.api.user.domain.Student;
import com.tazuzuapp.api.user.domain.User;
import com.tazuzuapp.api.user.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ActivityInstanceService {
    private final ActivityTypeRepository activityTypeRepository;
    private final ActivityInstanceRepository activityInstanceRepository;
    private final StudentRepository studentRepository;
    private final ActivityInstanceMeasurementRepository activityInstanceMeasurementRepository;

    private final NotificationService notificationService;

    @Autowired
    public ActivityInstanceService(
        ActivityTypeRepository activityTypeRepository,
        ActivityInstanceRepository activityInstanceRepository,
        StudentRepository studentRepository,
        ActivityInstanceMeasurementRepository activityInstanceMeasurementRepository,
        NotificationService notificationService
    ) {
        this.activityTypeRepository = activityTypeRepository;
        this.activityInstanceRepository = activityInstanceRepository;
        this.studentRepository = studentRepository;
        this.activityInstanceMeasurementRepository = activityInstanceMeasurementRepository;
        this.notificationService = notificationService;
    }

    public ActivityInstance createActivityInstance(ActivityInstanceRequest activityInstanceRequest, User user) throws Exception {
        ActivityInstance activityInstance = new ActivityInstance(activityInstanceRequest);
        activityInstance.setActivityType(activityTypeRepository.findOne(activityInstanceRequest.getActivityTypeId()));
        activityInstance.setUser(user);
        activityInstanceRepository.save(activityInstance);

        Long classId = activityInstanceRequest.getClassId();
        List<Student> students = new ArrayList<>();

        if (classId != null){
            students = studentRepository.findBySchoolClassId(classId);
        }else{
            List<Long> studentsIds = activityInstanceRequest.getStudentIds();
            if ( studentsIds == null || studentsIds.isEmpty() ) {
                throw new Exception("Must have at least one student in order to create activity");
            }

            for (Long studentId : activityInstanceRequest.getStudentIds()){
                students.add(studentRepository.findOne(studentId));
            }
        }

        for (Student s: students) {
            ActivityInstanceMeasurement activityInstanceMeasurement = new ActivityInstanceMeasurement();
            activityInstanceMeasurement.setStudent(s);
            activityInstanceMeasurement.setActivityInstance(activityInstance);
            activityInstanceMeasurementRepository.save(activityInstanceMeasurement);

            if ( s.getEmail() != null && !s.getEmail().isEmpty() ) {
                //Send notification
                notificationService.sendActivityNotification(s, activityInstanceMeasurement);
            }
        }

        return activityInstance;
    }

    public ActivityInstance getActivityInstance(Long id) {
        return activityInstanceRepository.findOne(id);
    }

    public List<ActivityInstanceMeasurement> getStudentPendingMeasurements(Long id) {
        Student s = studentRepository.findOne(id);
        return activityInstanceMeasurementRepository.findByStudentAndActivityInstanceActivityDateAfter(s, new Date());
    }

    public List<ActivityInstanceMeasurement> getStudentPastMeasurements(Long id) {
        Student s = studentRepository.findOne(id);
        return activityInstanceMeasurementRepository.findByStudentAndActivityInstanceActivityDateBefore(s, new Date());
    }

    public List<ActivityInstanceMeasurement> getMeasurementsByInstanceId(Long id) {
        return activityInstanceMeasurementRepository.findByActivityInstanceId(id);
    }

    public List<ActivityInstance> getTeacherPendingActivities(Long id) {
        return activityInstanceRepository.findByUserIdAndActivityDateAfter(id, new Date());
    }

    public List<ActivityInstance> getTeacherPastActivities(Long id) {
        return activityInstanceRepository.findByUserIdAndActivityDateBefore(id, new Date());
    }

}
