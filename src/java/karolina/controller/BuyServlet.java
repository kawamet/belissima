package karolina.controller;


import karolina.model.DAO.DaoProductImpl;
import karolina.model.DAO.DaoUserImpl;
import karolina.model.Product;
import karolina.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {
    private static final String PRODUCT_ID = "productId";
    private static final Long USER_ID = LoginServlet.userId;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter(PRODUCT_ID);

        DaoUserImpl daoUser = new DaoUserImpl();
        User user = daoUser.findById(USER_ID);

        DaoProductImpl daoProduct = new DaoProductImpl();
        Product product = daoProduct.findById(Long.parseLong(productId));

        user.addProduct(product);
        daoUser.merge(user);

        PrintWriter writer = resp.getWriter();
        writer.println("Bought: " + product.getItemName());
        writer.println("Your name: " + user.getUser());
    }
}
