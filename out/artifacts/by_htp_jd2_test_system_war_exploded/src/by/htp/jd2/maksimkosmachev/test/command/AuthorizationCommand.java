package by.htp.jd2.maksimkosmachev.test.command;

import by.htp.jd2.maksimkosmachev.test.entity.User;
import by.htp.jd2.maksimkosmachev.test.entity.enumpackage.Role;
import by.htp.jd2.maksimkosmachev.test.service.ClientService;
import by.htp.jd2.maksimkosmachev.test.service.ServiceFactory;
import by.htp.jd2.maksimkosmachev.test.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.htp.jd2.maksimkosmachev.test.command.RequestParameter.*;

public class AuthorizationCommand implements Command {

    private static final Logger logger=Logger.getLogger(AuthorizationCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceFactory serviceFactory=null;
        ClientService clientService=null;
        User user=null;

        String login = req.getParameter(LOGIN_PARAM_FROM_LOGIN_PAGE);
        String password = req.getParameter(PASSWORD_PARAM_FROM_LOGIN_PAGE);
        serviceFactory=ServiceFactory.getInstance();
        clientService=serviceFactory.getClientService();
        try {
            user=clientService.signIn(login,password);
            logger.info("get user from DB: "+user);
        } catch (ServiceException e) {
           logger.error("Exception during signing in "+e);
        }


        req.setAttribute("user",user);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/WEB-INF/jsp/Myprofile.jsp");
        requestDispatcher.forward(req,resp);




    }
}
