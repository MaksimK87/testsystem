package by.htp.jd2.maksimkosmachev.test.dao;

import by.htp.jd2.maksimkosmachev.test.dao.connectionpool.ConnectionPool;
import by.htp.jd2.maksimkosmachev.test.dao.exception.ConnectionPoolException;
import by.htp.jd2.maksimkosmachev.test.dao.exception.SuchUserExistException;
import by.htp.jd2.maksimkosmachev.test.dao.exception.SuchUserNotExistException;
import by.htp.jd2.maksimkosmachev.test.entity.User;
import by.htp.jd2.maksimkosmachev.test.entity.enumpackage.Role;
import org.apache.log4j.Logger;


import java.sql.*;

import static by.htp.jd2.maksimkosmachev.test.dao.SQLrequest.*;


public class SQLUserDAO implements UserDAO {


    private static final Logger logger = Logger.getLogger(SQLUserDAO.class);


    public SQLUserDAO() /*throws ConnectionPoolException*/ {
    }


    @Override
    public User signIn(String login, String password) throws ConnectionPoolException, SQLException, SuchUserNotExistException {
        User user = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_LOGIN_PASSWORD);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setUserDetailsId(resultSet.getInt(5));
                logger.info("getting information from user table");
            } else {
                logger.error("Such account doesn't exist!");
                throw new SuchUserNotExistException();
            }
            preparedStatement = connection.prepareStatement(GET_USER_DETAILS);
            preparedStatement.setInt(1, user.getUserDetailsId());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setName(resultSet.getString(2));
                user.setSurname(resultSet.getString(3));
                user.setRole(Role.valueOf(resultSet.getString(4)));
                logger.info("getting information from user details table" + user.toString());
            } else {
                logger.error("Such user details doesn't exist!");
                //throw new SuchUserNotExistException();
            }

        } finally {
            connectionPool.closeConnection(connection, preparedStatement);
            logger.info("closing connection from SQLUserDAO");
        }


        return user;
    }

    @Override
    public boolean registration(User user) throws ConnectionPoolException, SQLException, SuchUserExistException {

        logger.info("In registration method");

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.takeConnection();
        preparedStatement = connection.prepareStatement(FIND_BY_LOGIN);
        preparedStatement.setString(1, user.getLogin());
        resultSet = preparedStatement.executeQuery();
        logger.info("Try to find by login");
        if (resultSet.next()) {
            logger.error("Such user already exists! Try to use another login for registration! ");
            throw new SuchUserExistException("Such user already exists! Try to use another login for registration! ");

        }
            // connection.setAutoCommit(false);
            logger.info("Try to register user details ");
            preparedStatement = connection.prepareStatement(REGISTER_USER_DETAILS, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
           // preparedStatement.setString(3, user.getRole().toString());
            logger.info("Try to execute query "+user);
            resultSet=preparedStatement.executeQuery();
            logger.info("Execute query successful");
            //connection.setAutoCommit(true);
            ResultSet userDetailsId = preparedStatement.getGeneratedKeys();
            if (userDetailsId.next()) {
                user.setUserDetailsId(userDetailsId.getInt(1));
                logger.info("Insert id user details in table user details: " + user.getUserDetailsId());
            }
            // connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(REGISTER_USER_DATA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getUserDetailsId());
            preparedStatement.executeQuery();
            // connection.setAutoCommit(true);
            ResultSet userId = preparedStatement.getGeneratedKeys();
            if (userId.next()) {
                user.setId(userId.getInt(1));
                logger.info("Insert id user in table user: " + user.getId());
            }

            return true;



    }

}
