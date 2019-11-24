package by.htp.jd2.maksimkosmachev.test.dao;

import by.htp.jd2.maksimkosmachev.test.dao.connectionpool.ConnectionPool;
import by.htp.jd2.maksimkosmachev.test.dao.exception.ConnectionPoolException;
import by.htp.jd2.maksimkosmachev.test.dao.exception.SuchUserNotExistException;
import by.htp.jd2.maksimkosmachev.test.entity.User;
import by.htp.jd2.maksimkosmachev.test.entity.enumpackage.Role;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
            preparedStatement = connection.prepareStatement(SQLrequest.FIND_BY_LOGIN_PASSWORD);
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
            preparedStatement = connection.prepareStatement(SQLrequest.GET_USER_DETAILS);
            preparedStatement.setInt(1, user.getUserDetailsId());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setName(resultSet.getString(2));
                user.setSurname(resultSet.getString(3));
                user.setRole(Role.valueOf(resultSet.getString(4)));
                logger.info("getting information from user details table"+ user.toString());
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
    public boolean registration(User user) {

        return false;
    }

}
