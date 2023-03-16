package by.academy.jobService.service;

import by.academy.jobService.model.Task;
import by.academy.jobService.model.User;

import java.util.List;

public interface TaskService {

    Task findOne(Long id);

    List<Task> findAll();

    Task create(Task object);

    User update(Task object);

    void delete(Long id);
}
