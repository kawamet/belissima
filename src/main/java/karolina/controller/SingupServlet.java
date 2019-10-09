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
    private static final String USER = "user";
    public static final String PASSWORD = "password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter(USER);
        String password = request.getParameter(PASSWORD);


        //logger.warning("User:  " + user + "password: " + password);
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        if (password == null || user == null) {
            writer.println("Required parameters are not filled");
            request.getRequestDispatcher("/login.jsp").include(request, response);
        }else {
            DaoUserImpl daoUser = new DaoUserImpl();
            daoUser.persist(new User(user, password));
            writer.println("<h3>User created! Please log in</h3><br>");
            request.getRequestDispatcher("/login.jsp").include(request, response);
        }

    }

}
