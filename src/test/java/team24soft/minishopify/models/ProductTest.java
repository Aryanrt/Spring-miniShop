package team24soft.minishopify.models;

import org.junit.Before;
import org.junit.Test;
import spring.minishopify.models.Product;

import static org.junit.Assert.*;

public class ProductTest {
    Product p1;
    Product p2;
    String title;
    String description;
    int price;

    @Before
    public void setUp() throws Exception {
        title = "Coca";
        description = "Soda/Pop";
        price = 12;

        p1 = new Product(title,description,price);
        p2 = new Product();
    }

    @Test
    public void getTitle(){
        assertEquals(title,p1.getTitle());
    }
    @Test
    public void getDescription(){
        assertEquals(description,p1.getDescription());
    }
    @Test
    public void getPrice(){
        assertEquals(price,p1.getPrice());
    }

    @Test
    public void setTitle(){
        p2.setTitle(title);

        assertEquals(title,p2.getTitle());
    }
    @Test
    public void setDescription(){
        p2.setDescription(description);

        assertEquals(description, p2.getDescription());
    }
    @Test
    public void setPrice(){
        p2.setPrice(price);

        assertEquals(price,p2.getPrice());
    }
}