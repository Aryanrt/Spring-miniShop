package team24soft.minishopify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team24soft.minishopify.models.Cart;
import team24soft.minishopify.models.Product;
import team24soft.minishopify.models.Shop;
import team24soft.minishopify.models.User;
import team24soft.minishopify.repositories.*;

@Controller()
public class shopMVCController {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    // Create a Shop
    @PostMapping("/createShop")
    public String createBook(@ModelAttribute Shop shop){

        shopRepository.save(shop);

        return "shopManager";
    }


    @GetMapping("/getManagerShop")
    public String getManagerShop(@RequestParam(name="id", required = false, defaultValue = "1") long id, Model model){

        Shop shop = shopRepository.findById(id);

        model.addAttribute("shop", shop);

        return "shopManager";
    }

    @GetMapping ("/addItem")
    public String getItems(@RequestParam(name="id", required = true) long id,
                           @RequestParam(name="name", required = true) String name,
                           @RequestParam(name="description", required = false,defaultValue = "") String  description,
                           @RequestParam(name="price", required = false, defaultValue = "0") long price,
                           @RequestParam(name="quantity", required = false, defaultValue = "0") long quantity,
                           Model model){


        Product product = new Product(name,description,price, quantity);

       // product.setInventoryNumber(inventory);

        Shop shop = shopRepository.findById(id);

        productRepository.save(product);

        shop.addProduct(product);

        shopRepository.save(shop);

        model.addAttribute("shop", shop);

        return "shopManager";
    }

    @GetMapping("/getBuyerShop")
    public String getBuyerShop(@RequestParam(name="name", required = true) String name, Model model){

        Shop shop = shopRepository.findByName(name);

        model.addAttribute("shop", shop);

        return "shopUser";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam(name="name", required = true) String name,
                            @RequestParam(name="title", required = true) String title,
                            @RequestParam(name="number", required = true) int number, Model model){

        System.out.println("aaa" + name + " " + title + number);
        Cart cart;
        //if this is the first item in the cart, then create a Cart object
        if(cartRepository.count() == 0 )
        {
            cart = new Cart();
            cartRepository.save(cart);
        }
        else
            cart = cartRepository.findAll().iterator().next();

//        Shop shop = (Shop) model.getAttribute("shop");
       // model.addAttribute("shop", shop);
        //System.out.println(shopName);
        Shop shop = shopRepository.findByName(name);

        //shop.getProducts().
        for( Product product: shop.getProducts()) {
            System.out.println(product.getTitle());
            if (product.getTitle().equals(title)) {
                boolean alreadyInCart = false;
                for(Product p : cart.products)
                {
                    //if product is already in the cart, just add up the quantities
                    if(p.getId() == product.getId())
                    {
                        cartRepository.delete(cart);
                        cart.removeProduct(p);
                        p.setQuantity(p.getQuantity()+ number);
                        cart.addProduct(p);
                        cartRepository.save(cart);
                        System.out.println("added 2");
                        alreadyInCart = true;
                        break;
                    }
                }
                if(alreadyInCart)
                    break;
                product.setQuantity(number);
                cart.addProduct(product);
                System.out.println("1111111");
                cartRepository.save(cart);
                System.out.println("added");
                break;
            }
        }
        model.addAttribute("shop", shop);

        //model.addAttribute("shop", shop);
        return "shopUser";

        //return "shopUser";
    }
/*
    @GetMapping("/removeFromCart")
    public String removeFromCart(@RequestParam(name="name", required = true) String name,
                            @RequestParam(name="title", required = true) String title, Model model){

        Cart cart = cartRepository.findAll().iterator().next();
        cart.removeProduct();
        model.addAttribute("cart", cart);

        return "cart";
        }
        model.addAttribute("shop", shop);

        //model.addAttribute("shop", shop);
        return "shopUser";

        //return "shopUser";
    }

*/
    @GetMapping("/viewCart")
    public String viewCart(Model model){

        Cart cart;
        if(cartRepository.count() == 0 )
        {
            cart = new Cart();
            cartRepository.save(cart);
        }
        else
            cart = cartRepository.findAll().iterator().next();

        model.addAttribute("cart", cart);

        return "cart";
    }
    @GetMapping("/login")
    public String login(@RequestParam(name="username", required = true) String username,
                        @RequestParam(name="password", required = true) String password, Model model) {

        if (userRepository.findByUsername(username) == null) {
            return "index";
        }
        if (userRepository.findByUsername(username).getPassword().equals(password)) {
            User user = userRepository.findByUsername(username);
            user.setOnline(true);
            userRepository.save(user);
            return "welcome";
        }
        return "index";
    }
    @GetMapping("/register")
    public String register(@RequestParam(name="username", required = true) String username,
                           @RequestParam(name="password", required = true) String password,
                           @RequestParam(name="passwordRepeated", required = true) String passwordRepeated, Model model){

        User user = new User(username, password);
        user.setOnline(true);
        userRepository.save(user);

        return "welcome";
    }
    @GetMapping("/signOut")
    public String signOut(Model model){

        User user = userRepository.findByIsOnline(true);
        user.setOnline(false);
        userRepository.save(user);

        return "index";
    }



}
