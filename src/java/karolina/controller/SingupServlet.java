package karolina.controller;


import karolina.model.DAO.DaoUserImpl;
import karolina.model.User;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/singupServlet")
public class SingupServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(SingupServlet.class.getSimpleName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");


        logger.warning("KAROLINA User to " + user + "password to: " + password);
        PrintWriter writer = response.getWriter();
        if (password == null || user == null) {
            writer.println("Required parameters are not filled");
            request.getRequestDispatcher("/login.jsp").include(request, response);
        }else {
            DaoUserImpl daoUser = new DaoUserImpl();
            daoUser.persist(new User(user, password));
            writer.println("User created!");
            request.getRequestDispatcher("/login.jsp").include(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
    }
}
