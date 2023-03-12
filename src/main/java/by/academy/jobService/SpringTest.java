package by.academy.jobService;

import by.academy.jobService.repository.UserRepository;
import by.academy.jobService.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("by.academy.jobService");

        UserRepository userRepository = applicationContext.getBean("userRepositoryImpl", UserRepository.class);
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);

        System.out.println(userRepository.findAll());



    }
}
