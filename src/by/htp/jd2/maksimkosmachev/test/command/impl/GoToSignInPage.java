package by.htp.jd2.maksimkosmachev.test.command.impl;

import by.htp.jd2.maksimkosmachev.test.command.Command;
import by.htp.jd2.maksimkosmachev.test.entity.Test;
import by.htp.jd2.maksimkosmachev.test.service.ServiceFactory;
import by.htp.jd2.maksimkosmachev.test.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToSignInPage implements Command {

    private static final Logger logger = Logger.getLogger(GoToSignInPage.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceFactory serviceFactory;
        List<Test> tests = null;
        serviceFactory = ServiceFactory.getInstance();
        try {
            tests = serviceFactory.getTestService().getAllTest();
        } catch (ServiceException e) {
            logger.error("ServiceException" + e);
        }
        req.setAttribute("tests", tests);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp");
        requestDispatcher.forward(req, resp);
    }
}
