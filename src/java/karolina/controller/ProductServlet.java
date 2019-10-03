package karolina.controller;

import com.google.common.base.Throwables;
import karolina.model.DAO.DaoProductImpl;
import karolina.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ProductServlet.class.getSimpleName());
    public static final String ID = "id";
    private DaoProductImpl daoProductr;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParameter = req.getParameter(ID);
        daoProductr = new DaoProductImpl();

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        Optional<Long> id = getIdFromParamenetr(idParameter);
        Product productId;
        List<Product> all = daoProductr.findAll();
        if (idParameter == null) {
            writer.println("<h2>Tutaj wyswietl cala liste produktow</h2>");
            req.setAttribute("product_list", all);
            req.getRequestDispatcher("/allproducts.jsp").forward(req, resp);

        } else if (id.isPresent()) {
            productId = daoProductr.findById(Long.valueOf(idParameter));
            writer.println("ID:" + productId.getId());
            writer.println("Item name: " + productId.getItemName());
            writer.println("Category: " + productId.getCategory());
            writer.println("Price: " + productId.getPrice());


        } else {
            writer.println("<h2>Incorrect ID!</h2>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemName = request.getParameter("itemName");
        String category = request.getParameter("category");
        String itemAmount = request.getParameter("itemAmount");
        String price = request.getParameter("price");
        PrintWriter writer = response.getWriter();


        if (itemName == null || category == null || itemAmount == null || price == null) {
            writer.println("Required parameters are not filled");
        } else if (validateIntegarValues(price, itemAmount)) {
            //todo tutaj mozna to zrobic ladniej patrz builder DONE
            daoProductr = new DaoProductImpl();
            daoProductr.persist(new Product(itemName, category, Integer.parseInt(itemAmount), Integer.parseInt(price)));
            writer.println("Product is created");
        } else {
            writer.println("Integar values are ok");
        }

    }

    private boolean validateIntegarValues(String price, String amount) {
        try {
            Integer priceInteger = Integer.valueOf(price);
            Integer amountInteger = Integer.valueOf(amount);

            return priceInteger >= 0 && amountInteger >= 0;
        } catch (Exception e) {

            logger.warning("User gived us something wrong  =" + " price: " + price + " amount: " + amount);
            logger.warning(Throwables.getStackTraceAsString(e));
        }
        return false;
    }

    private Optional<Long> getIdFromParamenetr(String idParameter) {
        try {
            Long integer = Long.valueOf(idParameter);
            return Optional.of(integer);
        } catch (Exception e) {
            logger.warning(Throwables.getStackTraceAsString(e));
        }
        return Optional.empty();
    }

}
