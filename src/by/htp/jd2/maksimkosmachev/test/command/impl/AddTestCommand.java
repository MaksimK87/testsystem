package by.htp.jd2.maksimkosmachev.test.command.impl;

import by.htp.jd2.maksimkosmachev.test.command.Command;
import by.htp.jd2.maksimkosmachev.test.entity.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddTestCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        List<String> questions=new ArrayList<>();
        List<String> answers =new ArrayList<>();
        List<Boolean> isRightAnswer=new ArrayList<>();

        //Test test=null;

        if(session==null){
            resp.sendRedirect("Controller?command=go_to_sign_in_page&errorMessage=session invalidate!");
            return;
        }
        /*if(test==null){
            test=new Test();
        }*/

        session.setAttribute("questions",questions);
        session.setAttribute("answers",answers);
        session.setAttribute("isRight",isRightAnswer);


    }
}
