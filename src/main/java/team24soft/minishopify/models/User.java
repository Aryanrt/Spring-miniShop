package team24soft.minishopify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    private String username;
    private String password;
    private boolean isOnline;
    //private Cart cart;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;

    public User(String username, String password)
    {
        this.isOnline = true;
        this.username = username;
        this.password = password;
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
