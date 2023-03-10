package by.academy.jobService.service;

import by.academy.jobService.model.User;

import java.util.List;

public interface UserService {
    User findOne(Long id);

    List<User> findAll();

    User create(User object);

    User update(User object);

    void delete(Long id);
}
