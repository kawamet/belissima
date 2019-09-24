package karolina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "category")
    private String category;
    @Column(name = "item_amount")
    private int itemAmount;
    @Column(name = "price")
    private int price;

    public Product(String itemName, String category, int itemAmount, int price) {
        this.itemName = itemName;
        this.category = category;
        this.itemAmount = itemAmount;
        this.price = price;
    }

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