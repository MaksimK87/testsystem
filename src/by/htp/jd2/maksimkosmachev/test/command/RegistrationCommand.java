package by.htp.jd2.maksimkosmachev.test.command;

import by.htp.jd2.maksimkosmachev.test.entity.User;
import by.htp.jd2.maksimkosmachev.test.entity.enumpackage.Role;
import by.htp.jd2.maksimkosmachev.test.service.ServiceFactory;
import by.htp.jd2.maksimkosmachev.test.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.htp.jd2.maksimkosmachev.test.command.RequestParameter.*;

public class RegistrationCommand implements Command {

    private static final Logger logger=Logger.getLogger(RegistrationCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceFactory serviceFactory = null;
        boolean isRegistration = false;
        User user = new User();

        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setEmail(req.getParameter("email"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        user.setRole(Role.valueOf(req.getParameter("role")));
        serviceFactory=ServiceFactory.getInstance();
        try {
            isRegistration=serviceFactory.getClientService().registration(user);
            logger.info("User's registration is: "+isRegistration);
        } catch (ServiceException e) {
            logger.error("exception during registration "+e);
        }

        req.setAttribute("isRegistration",isRegistration);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/WEB-INF/jsp/successReg.jsp");
        requestDispatcher.forward(req,resp);
    }
}
