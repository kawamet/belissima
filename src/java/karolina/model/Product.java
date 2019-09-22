package karolina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private long id;
    private String itemName;
    private String category;
    private int itemAmount;
    private int price;

  /*  public void setId(String id) {
        this.id = Long.parseLong(id);
    }

    public void setItemAmount(String itemAmount) {
        this.itemAmount = Integer.parseInt(itemAmount);
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }*/

    public static class Builder {
        private long id;
        private String itemName;
        private String category;
        private int itemAmount;
        private int price;

        public Builder id(String id){
            this.id= Long.parseLong(id);
            return this;
        }
        public Builder itemAmount(String itemAmount){
            this.itemAmount= Integer.parseInt(itemAmount);
            return this;
        }
        public Builder price(String price){
            this.price= Integer.parseInt(price);
            return this;
        }

        public Product build(){
            return new Product(id, itemName, category, itemAmount, price);
        }
    }

}