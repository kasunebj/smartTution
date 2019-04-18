package com.solution.smartTution.servicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailClass {
    @Autowired
    private JavaMailSender javamailsender;

    public void emailGenerater(String to) {
        {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject("registration to smartTution");
            message.setText("User creation successful");
            javamailsender.send(message);

        }
    }}
