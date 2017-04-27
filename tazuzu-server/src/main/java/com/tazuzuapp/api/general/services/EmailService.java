package com.tazuzuapp.api.general.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@SuppressWarnings("unused")
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @SuppressWarnings("unused")
    public void SendEmail(
            InternetAddress emailSender, InternetAddress to, String subject, String htmlContent
    ) {

        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mail, true, "UTF-8");
            message.setFrom(emailSender);
            message.setTo(to);
            message.setSubject(subject);

            message.setText(htmlContent, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);

    }

}

