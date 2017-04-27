package com.tazuzuapp.api.activity.service;

import com.tazuzuapp.api.activity.domain.ActivityInstance;
import com.tazuzuapp.api.general.services.EmailService;
import com.tazuzuapp.api.user.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationService {

    private final EmailService emailService;

    private final EmailContentBuilder emailContentBuilder;

    @Autowired
    public NotificationService(EmailService emailService, EmailContentBuilder emailContentBuilder) {
        this.emailService = emailService;
        this.emailContentBuilder = emailContentBuilder;
    }

    public void sendActivityNotification(Student student, ActivityInstance activityInstance) throws UnsupportedEncodingException {

        Map<String, String> values = new HashMap<>();
        values.put("firstName", student.getFirstName());
        values.put("activityDate", activityInstance.getActivityDate().toString());

        String htmlContent = emailContentBuilder.build(values, "student-activity-notification");

        InternetAddress sender = new InternetAddress(
                "tazuzuapp@gmail.com",
                "Tazuzu app"
        );

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
