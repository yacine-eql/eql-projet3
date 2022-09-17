package com.eql.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(
                                String subject,
                                String body
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("yacine.saib@gmail.com");
        message.setTo("forteen3@gmail.com");
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);

    }

}
