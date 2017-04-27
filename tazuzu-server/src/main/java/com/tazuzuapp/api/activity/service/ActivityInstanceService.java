package com.tazuzuapp.api.activity.service;

import com.tazuzuapp.api.activity.domain.ActivityInstance;
import com.tazuzuapp.api.activity.domain.ActivityInstanceMeasurement;
import com.tazuzuapp.api.activity.domain.ActivityInstanceRequest;
import com.tazuzuapp.api.activity.repository.ActivityInstanceMeasurementRepository;
import com.tazuzuapp.api.activity.repository.ActivityInstanceRepository;
import com.tazuzuapp.api.activity.repository.ActivityTypeRepository;
import com.tazuzuapp.api.user.domain.Student;
import com.tazuzuapp.api.user.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityInstanceService {
    private final ActivityTypeRepository activityTypeRepository;
    private final ActivityInstanceRepository activityInstanceRepository;
    private final StudentRepository studentRepository;
    private final ActivityInstanceMeasurementRepository activityInstanceMeasurementRepository;

    @Autowired
    public ActivityInstanceService(ActivityTypeRepository activityTypeRepository, ActivityInstanceRepository activityInstanceRepository,
                                   StudentRepository studentRepository, ActivityInstanceMeasurementRepository activityInstanceMeasurementRepository) {
        this.activityTypeRepository = activityTypeRepository;
        this.activityInstanceRepository = activityInstanceRepository;
        this.studentRepository = studentRepository;
        this.activityInstanceMeasurementRepository = activityInstanceMeasurementRepository;
    }

    public ActivityInstance createActivityInstance(ActivityInstanceRequest activityInstanceRequest) {
        ActivityInstance activityInstance = new ActivityInstance(activityInstanceRequest);
        activityInstance.setActivityType(activityTypeRepository.findOne(activityInstanceRequest.getActivityTypeId()));
        activityInstanceRepository.save(activityInstance);
        ActivityInstanceMeasurement activityInstanceMeasurement = new ActivityInstanceMeasurement();

        Long classId = activityInstanceRequest.getClassId();
        List<Student> students = new ArrayList<>();

        if (classId != 0){
            students = studentRepository.findBySchoolClassId(classId);
        }
        else{
            for (Long studentId : activityInstanceRequest.getStudentIdList()){
                students.add(studentRepository.findOne(studentId));
            }
        }
        for (Student s: students) {
            activityInstanceMeasurement.setStudent(s);
            activityInstanceMeasurementRepository.save(activityInstanceMeasurement);
        }
        return activityInstance;
    }

    public boolean exists(Long id) {
        return activityInstanceRepository.exists(id);
    }

    public ActivityInstance updateActivityInstance(Long id, ActivityInstanceRequest activityInstanceRequest) {
        ActivityInstance activityInstance = activityInstanceRepository.findOne(id);
        activityInstance.setActivityType(activityTypeRepository.findOne(activityInstanceRequest.getActivityTypeId()));
        activityInstance.setActivityDate(activityInstanceRequest.getActivityDate());
        activityInstance.setNumOfMeasurements(activityInstanceRequest.getNumOfMeasurements());
        activityInstanceRepository.save(activityInstance);
        return activityInstance;
    }

    public List<ActivityInstance> getAllActivityInstance() {
        return activityInstanceRepository.findAll();
    }

    public ActivityInstance getActivityInstance(Long id) {
        return activityInstanceRepository.findOne(id);
    }
}
