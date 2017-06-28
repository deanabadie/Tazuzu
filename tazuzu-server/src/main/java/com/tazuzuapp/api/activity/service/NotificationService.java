package com.tazuzuapp.api.activity.service;

import com.tazuzuapp.api.ApplicationProperties;
import com.tazuzuapp.api.activity.domain.ActivityInstance;
import com.tazuzuapp.api.activity.domain.ActivityInstanceMeasurement;
import com.tazuzuapp.api.activity.repository.ActivityInstanceMeasurementRepository;
import com.tazuzuapp.api.general.services.EmailService;
import com.tazuzuapp.api.user.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class NotificationService {

    private final EmailService emailService;

    private final EmailContentBuilder emailContentBuilder;

    private final ApplicationProperties applicationProperties;

    private final ActivityInstanceMeasurementRepository measurementRepository;

    @Autowired
    public NotificationService(
            EmailService emailService,
            EmailContentBuilder emailContentBuilder,
            ApplicationProperties applicationProperties,
            ActivityInstanceMeasurementRepository measurementRepository
    ) {
        this.emailService = emailService;
        this.emailContentBuilder = emailContentBuilder;
        this.applicationProperties = applicationProperties;
        this.measurementRepository = measurementRepository;
    }

    private String generateParticipationToken(ActivityInstanceMeasurement measurement) {
        //Universal unique identifier
        String token = UUID.randomUUID().toString();

        measurement.setParticipationApprovalToken(token);
        measurementRepository.save(measurement);

        return token;
    }

     void sendActivityNotification(Student student, ActivityInstanceMeasurement measurement)
             throws UnsupportedEncodingException {

        if ( !applicationProperties.getEmails().getEnabled() ) {
            return;
        }

        String token = generateParticipationToken(measurement);

        Map<String, String> values = new HashMap<>();
        values.put("firstName", student.getFirstName());
        values.put("activityDate", measurement.getActivityInstance().getActivityDate().toString());
        values.put(
            "participationApprovalUrl",
            applicationProperties.getApiUrl() + "/activities/participation-approval?token=" + token
        );

        String htmlContent = emailContentBuilder.build(values, "student-activity-notification");

        InternetAddress sender = applicationProperties.getEmails().getFrom();

        InternetAddress to = new InternetAddress(
                student.getEmail(),
                student.getFirstName().concat(" ").concat(student.getLastName())
        );

        emailService.SendEmail(
                sender,
                to,
                "Activity notification",
                htmlContent
        );

    }

}
