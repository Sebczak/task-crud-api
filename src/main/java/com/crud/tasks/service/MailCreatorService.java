package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailCreatorService {

    @Qualifier("templateEngine")
    private final TemplateEngine templateEngine;
    private final AdminConfig adminConfig;
    private final TaskRepository taskRepository;
    private final JavaMailSender mailSender;

    public String buildTrelloCardEmail(String message) {

        Integer tasksCounter = taskRepository.findAll().size();
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("company_details", adminConfig.getCompanyName());
        context.setVariable("show_button", true);
        context.setVariable("is_friend", true);
        context.setVariable("application_functionality", functionality);
        context.setVariable("tasks_counter", tasksCounter);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    @Scheduled(fixedDelay = 86400000)
    public void sendTasksValueFromDatabase() throws MessagingException {
        Context context = new Context();
        int taskCount = taskRepository.findAll().size();
        context.setVariable("taskCount", taskCount);

        // Generate HTML content
        String htmlContent = templateEngine.process("taskEmailTemplate", context);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(adminConfig.getAdminMail());
        helper.setText(htmlContent, true);

        mailSender.send(message);
    }
}
