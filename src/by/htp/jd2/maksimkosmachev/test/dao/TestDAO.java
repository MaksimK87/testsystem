package by.htp.jd2.maksimkosmachev.test.dao;

import by.htp.jd2.maksimkosmachev.test.dao.exception.ConnectionPoolException;
import by.htp.jd2.maksimkosmachev.test.entity.Test;

import java.sql.SQLException;
import java.util.List;

public interface TestDAO {

    void addTest(Test test) throws ConnectionPoolException, SQLException;

    void editTest(Test test) throws ConnectionPoolException;

    void getTest(String name);

    List<Test> getAllTest() throws SQLException, ConnectionPoolException;

}
