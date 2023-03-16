package by.academy.jobService.repository;

import by.academy.jobService.model.Task;
import by.academy.jobService.model.User;

public interface TaskRepository extends CRUDRepository {

    void searchTask(Task id);

    void findAllActiveTasks();

    Task create(Task object);

    Task findLatestCreated();

}
