package by.academy.jobService.repository;

import by.academy.jobService.configuration.DatabaseProperties;
import by.academy.jobService.model.User;
import by.academy.jobService.utils.DBConnection;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.academy.jobService.repository.columns.UserColumns.*;

@Repository
@RequiredArgsConstructor
@Primary
@Component
public class UserRepositoryImpl implements UserRepository {
    //private final DatabaseProperties properties;

    private final Logger logger = Logger.getLogger(UserRepositoryImpl.class);
    DatabaseProperties properties;

    @Autowired
    public UserRepositoryImpl(DatabaseProperties properties) {
        this.properties = properties;
    }

    @Override
    public Object findOne(Object id) {
        return null;
    }

    @Override
    public List<User> findAll() {

        logger.info("Start of findAll method");

        DBConnection dbConnection = new DBConnection(properties);

        final String findAllQuery = "select * from pg.\"pg.m_users\" order by id desc";

        List<User> result = new ArrayList<>();

        dbConnection.registerDriver();
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findAllQuery)
        ) {

            while (rs.next()) {
                result.add(parseResultSet(rs));
            }

            logger.info("End of findAll method");

            return result;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("SQL Issues!");
        }
    }

    @Override
    public User create(User object) {
        return null;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    private User parseResultSet(ResultSet rs) {
        User user;

        try {
            user = new User();
            user.setId(rs.getLong(ID)); //1 or id
            user.setName(rs.getString(NAME));
            user.setSurname(rs.getString(SURNAME));
            user.setEmail(rs.getString(EMAIL));
            user.setPassword(rs.getString(PASSWORD));
            user.setUserRole(rs.getInt(USER_ROLE));
            user.setCreatedAt(rs.getTimestamp(CREATED_AT));
            user.setModifiedAt(rs.getTimestamp(MODIFIED_AT));
            logger.info("Parsing result. id : " + user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

//    private void registerDriver() {
//        try {
//            Class.forName(properties.getDriverName());
//        } catch (ClassNotFoundException e) {
//            System.err.println("JDBC Driver Cannot be loaded!");
//            throw new RuntimeException("JDBC Driver Cannot be loaded!");
//        }
//    }

//    private Connection getConnection() {
//        logger.info("Connecting to database");
//        String jdbcURL = StringUtils.join(properties.getUrl(), properties.getPort(), properties.getName());
//        try {
//            return DriverManager.getConnection(jdbcURL, properties.getLogin(), properties.getPassword());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public void searchUser() {

    }

}
