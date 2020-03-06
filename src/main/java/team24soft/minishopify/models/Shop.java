package team24soft.minishopify.models;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Shop {

    public String name;
    public String category;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public List<Product> products;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;

    protected Shop(){}

    public Shop(String name, String category){
        products = new LinkedList<Product>();
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void addProduct(Product product)
    {
        this.products.add(product);
    }
}
