package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";
    private static final String ONE_TASK = "task";
    private static final String MORE_TASKS = "tasks";
    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
            simpleEmailService.send(
                    new Mail(
                            adminConfig.getAdminMail(),
                            SUBJECT,
                            "Currently in database you got: " + size + " " + (size == 1 ? ONE_TASK : MORE_TASKS)
                    )
            );
    }
}
