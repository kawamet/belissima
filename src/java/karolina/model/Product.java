package karolina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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


    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_product",
            joinColumns = @JoinColumn(name = "procuct_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    public Product(String itemName, String category, int itemAmount, int price) {
        this.itemName = itemName;
        this.category = category;
        this.itemAmount = itemAmount;
        this.price = price;
    }

    public void addUser(User user) {
        if (user == null) {
            users = new ArrayList<>();
        }
        users.add(user);

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

        public Builder id(String id) {
            this.id = Long.parseLong(id);
            return this;
        }

        public Builder itemAmount(String itemAmount) {
            this.itemAmount = Integer.parseInt(itemAmount);
            return this;
        }

        public Builder price(String price) {
            this.price = Integer.parseInt(price);
            return this;
        }

        public Product build() {
            return new Product(itemName, category, itemAmount, price);
        }
    }

}