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

public class AddAnswerCommand implements Command {

    private static final Logger logger = Logger.getLogger(AddAnswerCommand.class);

    private static int answerCounter;
    private static int questionCounter;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int testQuestionId;
        String answerText;
        boolean rightAnswer = false;

        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect("Controller?command=go_to_sign_in_page&errorMessage=session invalidate!");
            return;
        }

        answerText = req.getParameter("answerText");
        testQuestionId = (int) session.getAttribute("testQuestionId");

        logger.debug("answerText: \n " +answerText+ "questionId: \n" +testQuestionId);

        switch (req.getParameter("isCorrectAnswer")) {

            case "correct":
                rightAnswer = true;
                break;
            case "incorrect":
                rightAnswer = false;
                break;
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();


        try {

            serviceFactory.getTestService().addAnswer(answerText, rightAnswer, testQuestionId);

        } catch (ServiceException e) {

            resp.sendRedirect("error.jsp");

            logger.error("Exception during writing test's question in DB");

            return;

        }
        answerCounter = (int) session.getAttribute("answerCounter");

        logger.debug("answer counter: " +answerCounter);

        answerCounter++;

        session.setAttribute("answerCounter", answerCounter);

        if ((int) session.getAttribute("answerCounter") > (int) session.getAttribute("answerQuantity")) {
            logger.debug("answer counter bigger than answer quantity: " +
                    session.getAttribute("answerCounter") + " > " + " " + session.getAttribute("answerQuantity"));
            answerCounter = 0;

            questionCounter= (int) session.getAttribute("questionCounter");
            questionCounter++;
            logger.debug("questionCounter after increment: "+questionCounter);
            session.setAttribute("questionCounter",questionCounter);

                      // resp.sendRedirect("Controller?command=add_test_question");
                        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/addQuestion.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/addAnswer.jsp");
        requestDispatcher.forward(req, resp);

    }
}
