package by.htp.jd2.maksimkosmachev.test.service;

import by.htp.jd2.maksimkosmachev.test.entity.User;
import by.htp.jd2.maksimkosmachev.test.service.exception.ServiceException;

public interface ClientService {

    User signIn(String login, String password) throws ServiceException;

    boolean registration(User user) throws ServiceException;

    boolean signOut(String login) throws ServiceException;
}
