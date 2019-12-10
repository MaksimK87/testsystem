package by.htp.jd2.maksimkosmachev.test.service;

import by.htp.jd2.maksimkosmachev.test.dao.DAOFactory;
import by.htp.jd2.maksimkosmachev.test.dao.exception.ConnectionPoolException;
import by.htp.jd2.maksimkosmachev.test.entity.Test;
import by.htp.jd2.maksimkosmachev.test.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class TestServiceImpl implements TestService {

    private static final Logger logger = Logger.getLogger(TestServiceImpl.class);

    @Override
    public void addTest(Test test) throws ServiceException {
        if (test != null) {
            DAOFactory daoFactory = DAOFactory.getInstance();
            try {
                daoFactory.getTestDAO().addTest(test);
            } catch (ConnectionPoolException e) {
                logger.error("Connection pool exception "+e);
                throw new ServiceException("Exception in connection pool " + e);
            } catch (SQLException e) {
                logger.error("SQLException" +e);
                throw new ServiceException("SQL exception " + e);
            }
        }
    }

    @Override
    public void editTest(Test test) {

    }

    @Override
    public Test getTest() {
        return null;
    }

    @Override
    public List<Test> getAllTest() throws ServiceException {
        List<Test> tests;
        DAOFactory daoFactory = DAOFactory.getInstance();
        try {
            tests = daoFactory.getTestDAO().getAllTest();
        } catch (SQLException e) {
            logger.error("SQLException" +e);
            throw new ServiceException("SQL exception " + e);
        } catch (ConnectionPoolException e) {
            logger.error("Connection pool exception "+e);
            throw new ServiceException("Exception in connection pool " + e);
        }
        if(tests==null||tests.isEmpty()){
            logger.error("Tests doesn't exist");
            throw new ServiceException("Tests doesn't exist!");
        }
        return tests;
    }
}
