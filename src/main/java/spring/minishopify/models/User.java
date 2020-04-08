package spring.minishopify.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    private String username;
    private String password;
    private boolean isOnline;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Cart cart;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;

    public User(String username, String password)
    {
        this.isOnline = true;
        this.username = username;
        this.password = password;
        this.cart = new Cart();
    }
    protected User(){}
    public String getUsername()
    {
        return this.username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return this.password;
    }
    public boolean isOnline() {
        return isOnline;
    }
    public Cart getCart() { return cart;}
    public long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public void setId(long id) {
        this.id = id;
    }
   // public void  setCart(Cart cart) { this.cart = cart; }
    //public Cart getCart() { return cart;}
}
