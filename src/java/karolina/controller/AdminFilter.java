package karolina.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static karolina.controller.AdminServlet.ADMIN_PRIVILEGE;
import static karolina.controller.AdminServlet.PRIVILEGE;

//mozna dodac tylko produkty jesli jest sie zaogowanym

@WebFilter(filterName = "AdminFilter", urlPatterns = {"/product", "/product.jsp"})
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //before
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        String privilege = (String) session.getAttribute(PRIVILEGE);

        //action
        if (ADMIN_PRIVILEGE.equals(privilege)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.setContentType("text/html");
            PrintWriter writer = servletResponse.getWriter();
            writer.println("<h1> Unautorized access! </h1><br>");
            servletRequest.getRequestDispatcher("/index.jsp").include(servletRequest, servletResponse);
        }
        //after
        //tutaj nie jest potrzebe

    }
}
