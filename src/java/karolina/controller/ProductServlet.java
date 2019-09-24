package karolina.controller;

import com.google.common.base.Throwables;
import karolina.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ProductServlet.class.getSimpleName());
    public static final String ID = "id";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParameter = req.getParameter(ID);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        Optional<Long> id = getIdFromParamenetr(idParameter);
        if (idParameter ==null){
            // todo wyswietl cala liste
            writer.println("<h2>Tutaj wyswietl cala liste produktow</h2>");
        }else if (id.isPresent()){
            //todo wyswietl konkretny produkt
            writer.println("<h2> tutaj wyswietle konkretny produkt" + idParameter + "</h2>");
        }else {
            writer.println("<h2>NIEPOPRAWNY ID!</h2>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String itemName = request.getParameter("itemName");
        String category = request.getParameter("category");
        String itemAmount = request.getParameter("itemAmount");
        String price = request.getParameter("price");
        PrintWriter writer = response.getWriter();

        if (id == null || itemName == null || category ==null || itemAmount ==null || price ==null ){
            writer.println("Required parameters are not filled");
        }else if (validateIntegarValues(id, price, itemAmount)){
            //todo tutaj mozna to zrobic ladniej patrz builder
            Product product = new Product(Integer.parseInt(id), itemName, category, Integer.parseInt(itemAmount), Integer.parseInt(price));
            writer.println("Product id created");
        }else {
            writer.println("integar values are ok");
        }

    }

    private boolean validateIntegarValues(String id, String price, String amount) {
        try {
            Integer idInteger = Integer.valueOf(id);
            Integer priceInteger = Integer.valueOf(price);
            Integer amountInteger = Integer.valueOf(amount);

            return idInteger>=0 && priceInteger >=0 && amountInteger >= 0;
        }catch (Exception e){

            logger.warning("User gived us something wrong : id =" + id + " price: " + price + " amount: " + amount);
            logger.warning(Throwables.getStackTraceAsString(e));
        }
        return false;
    }

    private Optional<Long> getIdFromParamenetr(String idParameter){
        try {
            Long integer = Long.valueOf(idParameter);
            return Optional.of(integer);
        }catch (Exception e){
            logger.warning(Throwables.getStackTraceAsString(e));
        }
        return Optional.empty();
    }

}
