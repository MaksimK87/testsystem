package by.htp.jd2.maksimkosmachev.test.service;

import by.htp.jd2.maksimkosmachev.test.entity.Test;
import by.htp.jd2.maksimkosmachev.test.service.exception.ServiceException;

import java.util.List;

public interface TestService {
    void addTest(Test test) throws ServiceException;

    void editTest(Test test);

    Test getTest();

    List<Test> getAllTest() throws ServiceException;

    int addTest(String name,int duration) throws ServiceException;

    int addTestQuestion(String question,int testId) throws ServiceException;

    void addAnswer(String answer, boolean isRight, int questionId) throws ServiceException;


}
