package team24soft.minishopify.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shop {

    public String name;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public List<Category> categories;

//    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    public List<Product> products;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;

}
