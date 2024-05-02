package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimpleEmailService {

    private final JavaMailSender mailSender;

    public SimpleEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(Mail mail) {
        log.info("Sending  an email");
        try {
            SimpleMailMessage mailMessage = createMailMessage(mail);
            mailSender.send(mailMessage);
            log.info("Email send");
        } catch (MailException e) {
            log.error("Failed to send an email. Error code: {}", e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMailMessage(Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        if (mail.getToCc() != null) {
            mailMessage.setCc(mail.getToCc());
        }
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());

        return mailMessage;
    }
}
