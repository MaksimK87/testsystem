package by.htp.jd2.maksimkosmachev.test;

import by.htp.jd2.maksimkosmachev.test.dao.SQLUserDAO;
import by.htp.jd2.maksimkosmachev.test.dao.exception.ConnectionPoolException;
import by.htp.jd2.maksimkosmachev.test.dao.exception.SuchUserNotExistException;
import by.htp.jd2.maksimkosmachev.test.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
       /* User user;
        String login="Ivan";
        String password="123456";
        ResultSet resultSet;
        int id=1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jd2_test_system?verifyServerCertificate=false &useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC",
                    "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LOGIN);
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
                logger.info("getting information from user table "+user.toString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


        try {
            SQLUserDAO sqlUserDAO = new SQLUserDAO();
            User user = sqlUserDAO.signIn("Ivan", "123456");
            System.out.println(user);
        } catch (ConnectionPoolException e) {
            logger.info("Error in Connection pool");
        } catch (SQLException e) {
            logger.info("Error in SQL");
        } catch (SuchUserNotExistException e) {
            logger.info("Such user not exist");
        }
       logger.info("In logger");

    }

    }
