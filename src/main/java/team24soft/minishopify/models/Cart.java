package team24soft.minishopify.models;

import javafx.util.Pair;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Cart {

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public List<Product> products;

    @ElementCollection
    public Map<Product, Integer> contents;


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;


    public Cart()
    {
        contents = new HashMap<Product,Integer>();
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

    public void addProduct(Product product, int number){

        this.products.add(product);
        contents.put(product,number);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }
}
