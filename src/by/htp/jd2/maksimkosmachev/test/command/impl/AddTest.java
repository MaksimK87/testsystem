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
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddTest implements Command {

    private static final Logger logger = Logger.getLogger(AddTest.class);

    private static int questionCounter = 1;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int questionQuantity = 0;
        int testId;
        String testName;
        int testDuration;

        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect("Controller?command=go_to_sign_in_page&errorMessage=session invalidate!");
            return;
        }
        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        testName = req.getParameter("testName");
        testDuration = Integer.parseInt(req.getParameter("duration"));

        logger.debug("test name is: " + testName + " duration: " + testDuration + " questions quantity: " +
                req.getParameter("questionQuantity"));

        try {

            testId = serviceFactory.getTestService().addTest(testName, testDuration);
            questionQuantity = Integer.parseInt(req.getParameter("questionQuantity"));
            logger.debug("Write in DB parameters about test: " + testName + ", duration: " + testDuration +
                    ", testID: " + testId);

        } catch (ServiceException e) {

            resp.sendRedirect("error.jsp");
            logger.error("Exception during writing test's name and duration in DB");
            return;
        }


        session.setAttribute("goto_req", "Controller?command=go_to_add_test");
        session.setAttribute("testId", testId);
        session.setAttribute("questionQuantity", questionQuantity);
        session.setAttribute("testName", testName);
        session.setAttribute("duration", testDuration);
        session.setAttribute("questionCounter", questionCounter);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/addQuestion.jsp");
        requestDispatcher.forward(req, resp);

    }
}
