package by.academy.jobService.service;

import by.academy.jobService.model.User;
import by.academy.jobService.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    //private final RandomValuesGenerator randomValuesGenerator;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        //this.randomValuesGenerator = randomValuesGenerator;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        /*Validation layer*/
        return userRepository.findAll();
    }

    @Override
    public User create(User object) {
        /*Validation layer*/
        if (object.getName() == "null") {
            throw new RuntimeException("Something wrong!");
        }

        return (User) userRepository.create(object);
    }

    @Override
    public User update(User object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
