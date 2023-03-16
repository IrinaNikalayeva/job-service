package by.academy.jobService.configuration;

import by.academy.jobService.model.Task;
import by.academy.jobService.utils.DBConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    //    @Bean
//    public DBConnection dbConnection(DatabaseProperties properties) {
//        return new DBConnection(properties);
//
//    }
//
//    @Bean
//    public DatabaseProperties databaseProperties(){
//        return new DatabaseProperties();
//    }
    @Bean
    public Task task() {
        return new Task();
    }

}
