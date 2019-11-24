package by.htp.jd2.maksimkosmachev.test.service;

import by.htp.jd2.maksimkosmachev.test.dao.DAOFactory;
import by.htp.jd2.maksimkosmachev.test.dao.UserDAO;
import by.htp.jd2.maksimkosmachev.test.dao.exception.ConnectionPoolException;
import by.htp.jd2.maksimkosmachev.test.dao.exception.SuchUserNotExistException;
import by.htp.jd2.maksimkosmachev.test.entity.User;
import by.htp.jd2.maksimkosmachev.test.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class ClientServiceImpl implements ClientService {

    private static final Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Override
    public User signIn(String login, String password) throws ServiceException {
        User user=null;
        if (login == null || login.isEmpty()) {
            logger.error("Incorrect or empty login");
            throw new ServiceException("Incorrect or empty login");
        }
        if (password == null || password.isEmpty()) {
            logger.error("password wasn't entered");
            throw new ServiceException("password wasn't entered");
        }
        try {
            DAOFactory daoObjFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoObjFactory.getUserDAO();
            user=userDAO.signIn(login, password);
        } catch (ConnectionPoolException e) {
            logger.error("ConnectionPoolException" +e);
        } catch (SQLException e) {
            logger.error("SQLException" +e);
        } catch (SuchUserNotExistException e) {
            logger.error("SuchUserNotExistException "+e);
        }

        return user;
    }

    @Override
    public boolean registration(User user) throws ServiceException {
        return false;
    }

    @Override
    public boolean signOut(String login) throws ServiceException {
        return false;
    }
}
