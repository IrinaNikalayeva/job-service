package by.academy.jobService.repository;

import by.academy.jobService.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CRUDRepository {
    void searchUser();

    User create(User object);
}
