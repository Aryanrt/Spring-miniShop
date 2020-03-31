package team24soft.minishopify.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
    Shop s1;
    Product p1;
    Cart cart;
    String name;
    Category category;
    String title;
    String description;
    long price;
    long quantity;

    @Before
    public void setUp() throws Exception {
        name = "Coca";
        category = Category.Drinks;
        title = "sprite";
        description ="tasty";
        price = 2;
        quantity = 100;

        s1 = new Shop(name, category);
        p1 = new Product(title,description,price,quantity);
        cart = new Cart();
        s1.addProduct(p1);
    }

    @Test
    public void addToCart(){
        cart.addProduct(p1);
        assertEquals(cart.getProducts().size(), 1);
        assertEquals(cart.getProducts().get(0), p1);
    }
    @Test
    public void removeFromCart(){
        cart.removeProduct(p1);
        assertEquals(cart.getProducts().size(), 0);
    }

}