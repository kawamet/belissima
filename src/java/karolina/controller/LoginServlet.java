package karolina.controller;

import karolina.model.DAO.DaoUserImpl;
import karolina.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ProductServlet.class.getSimpleName());


    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    public static final String PRIVILEGE = "privilege";
    public static final String ADMIN_PRIVILEGE = "admin";
    public static final String USER_PRIVILEGE = "user";

    //czy podal donre dane jesli tak to nadaje mu nowa sesje
    //jesli zle to ta sama strona + informacja ze jest niepoprawnie (include)
    //jesli dobre to przekazanie do indeksu forward

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        String user = request.getParameter(USER);
        String password = request.getParameter(PASSWORD);


        if (ADMIN_USER.equals(user) && ADMIN_PASSWORD.equals(password)) {
            setAdminPrivilage(request);
            logger.info("Autorized for: " + user);
            writer.println("<h1>Successfully logged!</h1><br>");
            request.getRequestDispatcher("/index.jsp").include(request, response);

            //todo chcek in database if user exists if not create new one
        } else if (chcekUser(user, password)) {
            setUserPrivilege(request);

            writer.println("<h1>Successfully logged!</h1><br>");
            request.getRequestDispatcher("/shop.jsp").include(request, response);
        } else {
            logger.warning("Wrong autorisation! Password: " + password + "user: " + user);
            writer.println("<h1>Wrong user or password</h1><br>");
            request.getRequestDispatcher("/login.jsp").include(request, response);
        }


    }

    public boolean chcekUser(String user, String password) {
        boolean exist = false;
        DaoUserImpl daoUser = new DaoUserImpl();
        List<User> all = daoUser.findAll();
        for (User user1 : all) {
            if (user.equals(user1.getUser())) {
                if (password.equals(user1.getPassword())) {
                    exist = true;
                }
            }
        }
        return exist;
    }

    private void setAdminPrivilage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(PRIVILEGE, ADMIN_PRIVILEGE);

    }

    private void setUserPrivilege(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(PRIVILEGE, USER_PRIVILEGE);

    }

  /* private void setAdminPrivilageCookie(HttpServletResponse response){
        Cookie cookie = new Cookie(PRIVILEGE, ADMIN_PRIVILEGE);
        response.addCookie(cookie);*/



}
