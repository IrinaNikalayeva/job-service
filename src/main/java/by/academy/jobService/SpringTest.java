package by.academy.jobService;

import by.academy.jobService.model.Task;
import by.academy.jobService.service.TaskService;
import by.academy.jobService.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("by.academy.jobService");

        //UserRepository userRepository = applicationContext.getBean("userRepositoryImpl", UserRepository.class);
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        TaskService taskService = applicationContext.getBean("taskServiceImpl", TaskService.class);
        //System.out.println(userRepository.findAll());
        //System.out.println(userService.findAll());
        Task task = applicationContext.getBean("task", Task.class);
        task = task.builder().clientId(4L)
                .executorId(1L)
                .description("sdfds")
                .status(1)
                .build();
        System.out.println(taskService.create(task));


    }
}
