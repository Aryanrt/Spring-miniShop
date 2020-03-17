package team24soft.minishopify.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public List<Product> products;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;

    public Cart()
    {
        this.products = new ArrayList<Product>();
        //this.setId(1000);
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }
}
