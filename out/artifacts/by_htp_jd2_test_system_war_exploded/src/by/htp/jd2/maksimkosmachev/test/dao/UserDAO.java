package by.htp.jd2.maksimkosmachev.test.dao;

import by.htp.jd2.maksimkosmachev.test.dao.exception.ConnectionPoolException;
import by.htp.jd2.maksimkosmachev.test.dao.exception.SuchUserNotExistException;
import by.htp.jd2.maksimkosmachev.test.entity.User;

import java.sql.SQLException;

public interface UserDAO {
    User signIn(String login, String password) throws ConnectionPoolException, SQLException, SuchUserNotExistException;
    boolean registration(User user);

}
