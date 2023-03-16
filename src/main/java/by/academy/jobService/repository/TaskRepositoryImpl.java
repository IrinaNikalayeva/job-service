package by.academy.jobService.repository;

import by.academy.jobService.configuration.DatabaseProperties;
import by.academy.jobService.model.Task;
import by.academy.jobService.repository.columns.TaskColumns;
import by.academy.jobService.utils.DBConnection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

import static by.academy.jobService.repository.columns.TaskColumns.*;
import static by.academy.jobService.repository.columns.TaskColumns.ID;
import static by.academy.jobService.repository.columns.UserColumns.MODIFIED_AT;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final Logger logger = Logger.getLogger(TaskRepositoryImpl.class);

    DatabaseProperties properties;

    @Autowired
    public TaskRepositoryImpl(DatabaseProperties properties) {
        this.properties = properties;
    }

    @Override
    public Object findOne(Object id) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Task create(Task object) {
        logger.info("Start creating a task...");
        DBConnection dbConnection = new DBConnection(properties);

        final String createTaskQuery = "insert into pg.\"pg.m_tasks\" " +
                "(client_id, executor_id, description, status, created_at, modified_at) " +
                "values(?, ?, ?, ?)";
        dbConnection.registerDriver();
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(createTaskQuery)) {
            preparedStatement.setLong(1, object.getClientId().intValue());
            preparedStatement.setLong(2, object.getExecutorId().intValue());
            preparedStatement.setString(3, object.getDescription());
            preparedStatement.setInt(4, object.getStatus());

            logger.info("End of findAll method");
            return findLatestCreated();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("SQL Issues!");
        }

    }

    @Override
    public Task findLatestCreated() {
        DBConnection dbConnection = new DBConnection(properties);
        final String findMaxIdQuery = "select * from pg.\"pg.m_tasks\" where " +
                "id=( SELECT max(id) FROM pg.\"pg.m_tasks\")";
        dbConnection.registerDriver();
        Task task = new Task();
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findMaxIdQuery)) {
            if (rs.next()) {
                task = parseResultSet(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("SQL Issues!");
        }
        return task;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public void searchTask(Task id) {

    }

    @Override
    public void findAllActiveTasks() {

    }

    private Task parseResultSet(ResultSet rs) {
        Task task;

        try {
            task = new Task();
            task.setId(rs.getLong(ID));
            task.setClientId(rs.getLong(CLIENT_ID));
            task.setExecutorId(rs.getLong(EXECUTOR_ID));
            task.setDescription(rs.getString(DESCRIPTION));
            task.setStatus(rs.getInt(STATUS));
            task.setCreatedAt(rs.getTimestamp(TaskColumns.CREATED_AT));
            task.setModifiedAt(rs.getTimestamp(MODIFIED_AT));
            logger.info("Parsing result. id : " + task.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return task;
    }
}
