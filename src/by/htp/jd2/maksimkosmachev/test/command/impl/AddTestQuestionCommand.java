package by.htp.jd2.maksimkosmachev.test.command.impl;

import by.htp.jd2.maksimkosmachev.test.command.Command;
import by.htp.jd2.maksimkosmachev.test.service.ServiceFactory;
import by.htp.jd2.maksimkosmachev.test.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddTestQuestionCommand implements Command {

    private static final Logger logger = Logger.getLogger(AddTestQuestionCommand.class);

    private static int questionCounter;
    private static int answerCounter=1;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int answerQuantity;
        int testQuestionId;
        String questionText;
        int testId;


        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect("Controller?command=go_to_sign_in_page&errorMessage=session invalidate!");
            return;
        }

        logger.debug("question counter"+session.getAttribute("questionCounter"));

        if ((int) session.getAttribute("questionCounter") > (int) session.getAttribute("questionQuantity")) {

            logger.debug("question counter bigger than question quantity: " +
                    session.getAttribute("questionCounter") + " > " + " " + session.getAttribute("questionQuantity"));

            questionCounter = 0;

            session.setAttribute("questionCounter",questionCounter);

            resp.sendRedirect("Controller?command=go_to_complete_add_test_page");
            return;
        }

        answerQuantity = Integer.parseInt(req.getParameter("answerQuantity"));
        questionText = req.getParameter("questionText");
        testId = (int) session.getAttribute("testId");

        logger.debug("questionText: " + questionText + " testId: " + testId);


        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        try {

            testQuestionId = serviceFactory.getTestService().addTestQuestion(questionText, testId);

        } catch (ServiceException e) {

            resp.sendRedirect("error.jsp");

            logger.error("Exception during writing test's question in DB");

            return;
        }

        session.setAttribute("answerQuantity", answerQuantity);
        session.setAttribute("testQuestionId", testQuestionId);

        session.setAttribute("questionText", questionText);
      //  session.setAttribute("answerOption", req.getParameter("option"));


        session.setAttribute("answerCounter",answerCounter);
        //questionCounter= (int) session.getAttribute("questionCounter");

       // logger.debug("question counter "+questionCounter);

        //questionCounter++;

        //session.setAttribute("questionCounter", questionCounter);






        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/addAnswer.jsp");
        requestDispatcher.forward(req, resp);

    }
}
