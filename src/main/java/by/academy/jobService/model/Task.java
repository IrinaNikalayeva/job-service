package by.academy.jobService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Task {

    private Long id;
    private Long clientId;
    private Long executorId;
    private String description;
    private Integer status;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

}
