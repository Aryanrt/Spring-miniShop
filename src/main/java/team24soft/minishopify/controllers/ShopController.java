package team24soft.minishopify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team24soft.minishopify.models.*;
import team24soft.minishopify.repositories.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.BindingResult;

@Controller()
public class ShopController {

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
    public String createBook( @Valid @ModelAttribute("shop") Shop shop,
                              BindingResult bindingResult,
                              @RequestParam(name="userId", required = true) long userId,
                              Model model){

        User user = userRepository.findById(userId);
        model.addAttribute("user", user);
        if (bindingResult.hasErrors()) {
            return "manager";
        }

        shopRepository.save(shop);

        model.addAttribute("product", new Product());
        model.addAttribute("shop", shop);

        return "shopManager";
    }


    @GetMapping("/getManagerShop")
    public String getManagerShop(@RequestParam(name="shopName") String shopName,
                                 @RequestParam(name="userId", required = true) long userId, Model model){

        User user = userRepository.findById(userId);
        model.addAttribute("user", user);
        Shop shop = shopRepository.findByName(shopName);
        model.addAttribute("shop", shop);
        model.addAttribute("product", new Product());


        return "shopManager";
    }

    @PostMapping ("/addItem")
    public String getItems(@Valid @ModelAttribute("product") Product product,
                           BindingResult bindingResult,
                           @RequestParam(name="shopName", required = true) String shopName,
                           @RequestParam(name="userId", required = true) long userId,
                           Model model){


        User user = userRepository.findById(userId);
        model.addAttribute("user", user);
        Shop shop = shopRepository.findByName(shopName);
        model.addAttribute("shop", shop);

        if (bindingResult.hasErrors()) {
            return "shopManager";
        }

        productRepository.save(product);
        shop.addProduct(product);
        shopRepository.save(shop);
        model.addAttribute("shop", shop);

        return "shopManager";
    }

    @GetMapping("/getBuyerShop")
    public String getBuyerShop(@RequestParam(name="name", required = true) String name,
                               @RequestParam(name="userId", required = true) long userId, Model model){
        User user = userRepository.findById(userId);
        model.addAttribute("user", user);

        Shop shop = shopRepository.findByName(name);

        model.addAttribute("shop", shop);

        return "shopUser";
    }
}
