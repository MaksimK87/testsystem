package by.htp.jd2.maksimkosmachev.test.dao;

import by.htp.jd2.maksimkosmachev.test.dao.connectionpool.ConnectionPool;
import by.htp.jd2.maksimkosmachev.test.dao.exception.ConnectionPoolException;
import by.htp.jd2.maksimkosmachev.test.entity.Test;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.htp.jd2.maksimkosmachev.test.dao.SQLrequest.*;

public class SQLTestDAO implements TestDAO {

    private static final Logger logger = Logger.getLogger(SQLTestDAO.class);

    @Override
    public void addTest(Test test) throws ConnectionPoolException, SQLException {
        logger.debug("In method addTest");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.takeConnection();

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(ADD_NEW_TEST, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, test.getTestName());
            preparedStatement.setInt(2, test.getTestDuration());
            preparedStatement.executeUpdate();
            logger.debug("Execution ADD_NEW_TEST query was successful");
            ResultSet idTest = preparedStatement.getGeneratedKeys();
            if (idTest.next()) {
                test.setId(idTest.getInt(1));
                logger.debug("id was generated for test " + test.getId());
            }

            preparedStatement = connection.prepareStatement(ADD_TEST_QUESTION, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, test.getQuestionText());
            preparedStatement.setInt(2, test.getId());
            preparedStatement.executeUpdate();
            logger.debug("Inserting question text and test id in Test questions table completed!");
            ResultSet idTestQuestion = preparedStatement.getGeneratedKeys();
            if (idTestQuestion.next()) {
                test.setIdTestQuestion(idTestQuestion.getInt(1));
                logger.debug("id_test_question was generated for test_questions " + test.getIdTestQuestion());
            }
            preparedStatement = connection.prepareStatement(ADD_TEST_ANSWER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, test.getAnswer());
            preparedStatement.setBoolean(2, test.isRightAnswer());
            preparedStatement.setInt(3, test.getIdTestQuestion());
            preparedStatement.executeUpdate();
            logger.debug("Inserting answer text, isRight and id_test_question in Test answers table completed!");
            ResultSet idTestAnswers = preparedStatement.getGeneratedKeys();
            if (idTestAnswers.next()) {
                test.setIdTestAnswer(idTestAnswers.getInt(1));
                logger.debug("id_test_answer was generated for test_answers " + test.getIdTestAnswer());
            }
        } finally {
            connection.setAutoCommit(true);
            connectionPool.closeConnection(connection, preparedStatement);
            logger.debug("closing connection from SQLTestDAO (method - addTest)");
        }

    }

    @Override
    public void editTest(Test test) {

    }

    @Override
    public void getTest(String name) {

    }

    public List<Test> getAllTest() throws SQLException, ConnectionPoolException {
        logger.debug("In get all test method");
        List<Test> tests = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.takeConnection();

        try {

            preparedStatement = connection.prepareStatement(SHOW_ALL_TESTS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                logger.debug("result set is processing");
                Test test = new Test();
                test.setTestName(resultSet.getString(2));
                test.setTestDuration(resultSet.getInt(3));
                logger.debug("Test from DB: " + test.getTestName() + " duration: " + test.getTestDuration());
                tests.add(test);
            }
        } finally {
            connectionPool.closeConnection(connection, preparedStatement);
            logger.debug("closing connection from SQLTestDAO (method - getAllTest)");
        }


        return tests;
    }

}
