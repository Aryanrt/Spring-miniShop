package team24soft.minishopify.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    private String title; //name given to product
    private String description; //description of the product
    private long quantity; //Quantity of the product
    private long price; //price of the product


    private int inventoryNumber;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public Product(){

    }

    //Contructor
    public Product(String title, String description, int price) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
