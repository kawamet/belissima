package karolina.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ProductServlet.class.getSimpleName());


    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    //czy podal donre dane jesli tak to nadaje mu nowa sesje
    //jesli zle to ta sama strona + informacja ze jest niepoprawnie (include)
    //jesli dobre to przekazanie do indeksu forward

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String user = request.getParameter(USER);
        String password = request.getParameter(PASSWORD);

        if (user.equals(ADMIN_USER) && password.equals(ADMIN_PASSWORD)) {
            logger.info("Autorized for: " + user);
            writer.println("<h1>Successfully logged!</h1><br>");
            request.getRequestDispatcher("/index.jsp").include(request,response);

        }else {
            logger.warning("Wrong autorisation! Password: " + password + "user: " + user);
            writer.println("<h1>Wrong user or password</h1><br>");
            request.getRequestDispatcher("/login.jsp").include(request,response);
        }


    }
}
