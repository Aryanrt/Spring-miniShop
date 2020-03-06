package team24soft.minishopify.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    private String title; //name given to product
    private String description; //description of the product
    private int price; //price of the product
    private String image;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long inventoryNumber;

    public Product(){

    }

    public Product(String title, String description, int price, String image) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

}