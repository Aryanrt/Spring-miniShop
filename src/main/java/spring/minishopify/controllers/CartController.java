package spring.minishopify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.minishopify.models.Cart;
import spring.minishopify.models.Product;
import spring.minishopify.models.Shop;
import spring.minishopify.models.User;
import spring.minishopify.repositories.CartRepository;
import spring.minishopify.repositories.ProductRepository;
import spring.minishopify.repositories.ShopRepository;
import spring.minishopify.repositories.UserRepository;

@Controller()
public class CartController {

    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam(name="name", required = true) String name,
                            @RequestParam(name="title", required = true) String title,
                            @RequestParam(name="number", required = true) int number,
                            @RequestParam(name="userId", required = true) long userId, Model model) {

        User user = userRepository.findById(userId);
        model.addAttribute("user", user);
        //boolean flag =false;

        Cart cart = user.getCart();
        cartRepository.save(cart);

        Shop shop = shopRepository.findByName(name);

        for (Product product : shop.getProducts()) {
            if (product.getTitle().equals(title)) {
                boolean alreadyInCart = false;
                for (Product p : cart.contents.keySet()) {
                    //if product is already in the cart, just add up the quantities
                    if (p.getId() == product.getId()) {
                        cartRepository.delete(cart);
                        cart.contents.put(p, (int) Math.min(cart.contents.get(p) + number, product.getQuantity()));
                        cartRepository.save(cart);
                        alreadyInCart = true;
                        break;
                    }
                }
                if (alreadyInCart)
                    break;

                for (Product product1 : shop.getProducts()) {
                    if (product1.getTitle().equalsIgnoreCase(title)) {
                        cart.contents.put(product1, (int) Math.min(number, product1.getQuantity()));
                        cartRepository.save(cart);
                        break;
                    }
                }//for
            }//if
        }//for
        model.addAttribute("shop", shop);

        //model.addAttribute("shop", shop);
        return "shopUser";

        //return "shopUser";
    }


    @GetMapping("/removeFromCart")
    public String removeFromCart(@RequestParam(name="title", required = true) String title,
                                 @RequestParam(name="name", required = true) String name,
                                 @RequestParam(name="userId", required = true) long userId, Model model){

        User user = userRepository.findById(userId);
        model.addAttribute("user", user);
        //Shop shop = (Shop) model.getAttribute("shop");

        Cart cart = user.getCart();
        Product p = null;

        for(Product product : shopRepository.findByName(name). getProducts())
        {
            if(product.getTitle().equalsIgnoreCase(title))
            {
                //System.out.println("hererererer" +cart.contents.get(product) +" "+ prd);
                //productRepository.delete(product);
                product.setQuantity(product.getQuantity()+ cart.contents.get(product));
                cart.contents.remove(product);
                //cart.contents.put(product, (int) Math.min(number, product.getQuantity()));
                cartRepository.save(cart);
                productRepository.save(product);
                //shopRepository.
                break;
            }
        }

        //model.addAttribute("shop", shop);
        model.addAttribute("cart", cart);
        return "cart";

    }


    @GetMapping("/viewCart")
    public String viewCart(@RequestParam(name="userId", required = true) long userId, Model model){
        User user = userRepository.findById(userId);
        model.addAttribute("user", user);

        Cart cart = user.getCart();
        cartRepository.save(cart);

      //  model.addAttribute("name", name);
        model.addAttribute("cart", cart);


        return "cart";
    }
    @GetMapping("/purchaseConfirmed")
    public String purchaseConfirmed(@RequestParam(name="userId", required = true) long userId, Model model){

        User user = userRepository.findById(userId);
        model.addAttribute("user", user);

        Cart cart = cartRepository.findAll().iterator().next();

        //update the productrepository with new contents
        for(Product product: cart.contents.keySet())
        {
            productRepository.findByTitle(product.getTitle()).setQuantity(productRepository.findByTitle(product.getTitle())
                    .getQuantity() - cart.contents.get(product));
        }

        cartRepository.delete(cart);
        return "purchaseConfirmed";
    }

}