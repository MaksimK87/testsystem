package by.htp.jd2.maksimkosmachev.test.command.impl;

import by.htp.jd2.maksimkosmachev.test.command.Command;
import by.htp.jd2.maksimkosmachev.test.entity.Test;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddTest implements Command {
    private static final Logger logger = Logger.getLogger(AddTest.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Test test = new Test();
        int questionQuantity;
        HttpSession session;
        test.setTestName(req.getParameter("testName"));
        test.setTestDuration(Integer.parseInt(req.getParameter("duration")));
        questionQuantity = Integer.parseInt(req.getParameter("questionQuantity"));
        logger.debug("Get parameters about test:" +test.getTestName()+" "+test.getTestDuration()+" "+
                " answers : "+questionQuantity);
        session=req.getSession(false);
        session.setAttribute("test",test);
        session.setAttribute("questionQuantity",questionQuantity);

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/WEB-INF/jsp/addQuestion.jsp");
        requestDispatcher.forward(req,resp);

    }
}
