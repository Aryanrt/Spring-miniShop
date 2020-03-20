package team24soft.minishopify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team24soft.minishopify.models.Cart;
import team24soft.minishopify.models.Product;
import team24soft.minishopify.models.Shop;
import team24soft.minishopify.models.User;
import team24soft.minishopify.repositories.CartRepository;
import team24soft.minishopify.repositories.ProductRepository;
import team24soft.minishopify.repositories.ShopRepository;
import team24soft.minishopify.repositories.UserRepository;

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
                            @RequestParam(name="userId", required = true) long userId, Model model){

        User user = userRepository.findById(userId);
        model.addAttribute("user", user);


        Cart cart;
        //if this is the first item in the cart, then create a Cart object
        if(cartRepository.count() == 0 )
        {
            cart = new Cart();
            cartRepository.save(cart);
        }
        else
            cart = cartRepository.findAll().iterator().next();

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

        @GetMapping("/removeFromCart")
        public String removeFromCart(@RequestParam(name="title", required = true) String title,
                                     @RequestParam(name="userId", required = true) long userId, Model model){

            User user = userRepository.findById(userId);
            model.addAttribute("user", user);
            Product product = null;

            for(Product p: productRepository.findAll())
                if(p.getTitle().equals(title))
                {
                    product = p;
                    break;
                }
            Cart cart = cartRepository.findAll().iterator().next();
            cartRepository.delete(cart);
            cart.removeProduct(product);
            cartRepository.save(cart);
            model.addAttribute("cart", cart);
            return "cart";

            //return "shopUser";
        }


    @GetMapping("/viewCart")
    public String viewCart(@RequestParam(name="userId", required = true) long userId, Model model){
        User user = userRepository.findById(userId);
        model.addAttribute("user", user);

        Cart cart;
        if(cartRepository.count() == 0 )
        {
            cart = new Cart();
            cartRepository.save(cart);
        }
        else
            cart = cartRepository.findAll().iterator().next();

        model.addAttribute("cart", cart);
        //model.addAttribute("user", user);

        return "cart";
    }
    @GetMapping("/purchaseConfirmed")
    public String purchaseConfirmed(@RequestParam(name="userId", required = true) long userId, Model model){

        User user = userRepository.findById(userId);
        model.addAttribute("user", user);

        Cart cart = cartRepository.findAll().iterator().next();
        cartRepository.delete(cart);
        //model.addAttribute("cart", cart);

        return "purchaseConfirmed";
    }

}
