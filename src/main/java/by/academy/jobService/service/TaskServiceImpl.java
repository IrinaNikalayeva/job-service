package by.academy.jobService.service;

import by.academy.jobService.model.Task;
import by.academy.jobService.model.User;
import by.academy.jobService.repository.TaskRepositoryImpl;
import by.academy.jobService.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepositoryImpl taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepositoryImpl taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task findOne(Long id) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.create(task);
    }

    @Override
    public User update(Task object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
