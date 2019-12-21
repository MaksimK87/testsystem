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

public class AddTestQuestion implements Command {
    private static final Logger logger = Logger.getLogger(AddTestQuestion.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Test test = new Test();
        System.out.println(req.getAttributeNames().nextElement());
        int answerQuantity;
        test.setTestName((String) req.getAttribute("testName"));
        test.setTestDuration((Integer) req.getAttribute("duration"));
        test.setQuestionText((String) req.getAttribute("questionText"));
        answerQuantity = (int) req.getAttribute("answerQuantity");
        logger.debug("Get parameters about test:" +test.getTestName()+" "+test.getTestDuration()+" "+
                test.getQuestionText()+ " answers : "+answerQuantity);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/WEB-INF/jsp/addAnswer.jsp");
        requestDispatcher.forward(req,resp);

    }
}
