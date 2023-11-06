package com.forestdise.service.impl;

import com.forestdise.entity.User;
import com.forestdise.entity.VerificationToken;
import com.forestdise.repository.UserRepository;
import com.forestdise.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendConfirmEmail(User user, String token) {
        SimpleMailMessage email = new SimpleMailMessage();
        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String message = "Thank you for registering to ForestDise." +
                " Please click on this link to verify your account and start shopping:";
        String verifyLink = "http://localhost:8080/api" + "/register/confirmation?token=" + token;
        String sentMessage = message + "\n" + verifyLink;
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(sentMessage);
        mailSender.send(email);
    }


}
