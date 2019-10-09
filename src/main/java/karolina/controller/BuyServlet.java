package karolina.controller;


import karolina.model.DAO.DaoProductImpl;
import karolina.model.DAO.DaoUserImpl;
import karolina.model.Product;
import karolina.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {
    private static final String PRODUCT_ID = "productId";
    private static final Long USER_ID = LoginServlet.userId;
    private static final Logger logger = Logger.getLogger(ProductServlet.class.getSimpleName());


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String productId = req.getParameter(PRODUCT_ID);

        DaoUserImpl daoUser = new DaoUserImpl();
        User user = daoUser.findById(USER_ID);

        DaoProductImpl daoProduct = new DaoProductImpl();
        Product product = null;
        try {
            product = daoProduct.findById(Long.parseLong(productId));
        } catch (NumberFormatException e){
            logger.warning("Long.parseLong(productId) unsuccessful!");
            e.getMessage();
        }

        user.addProduct(product);
        daoUser.merge(user);

        PrintWriter writer = resp.getWriter();
        writer.println("Bought: " + product.getItemName());
        writer.println("Your name: " + user.getUser());
    }
}
