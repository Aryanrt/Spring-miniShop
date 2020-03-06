package team24soft.minishopify.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShopTest {
    Shop s1;
    Shop s2;
    String name;
    String category;

    @Before
    public void setUp() throws Exception {
        name = "Coca";
        category = "Soda/Pop";

        s1 = new Shop(name, category);
        s2 = new Shop();
    }

    @Test
    public void getName(){
        assertEquals(name,s1.getName());
    }
    @Test
    public void getCategory(){
        assertEquals(category, s1.getCategory());
    }


    @Test
    public void setName(){
        s2.setName(name);

        assertEquals(name,s2.getName());
    }
    @Test
    public void setCategory(){
        s2.setCategory(category);

        assertEquals(category, s2.getCategory());
    }

    @Test
    public void addProduct(){
        s1.addProduct(new Product("Coca", "Pop", 12));

        assertEquals(s1.getProducts().size(), 1);
    }

}