package team24soft.minishopify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team24soft.minishopify.models.Shop;
import team24soft.minishopify.models.User;
import team24soft.minishopify.repositories.CartRepository;
import team24soft.minishopify.repositories.ProductRepository;
import team24soft.minishopify.repositories.ShopRepository;
import team24soft.minishopify.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Controller()
public class UserController {

    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/shopList")
    public String shopList(@RequestParam(name="userId", required = true) long userId,
                           @RequestParam(name="filter",required = false,defaultValue = "") String filter,
                           Model model){
        List<Shop> shops = new ArrayList<Shop>();

        shops.addAll(shopRepository.findByCategoryOrName(filter,filter));

        if(filter.equals("")){
            shops.addAll((List<Shop>)shopRepository.findAll());
        }

        User user = userRepository.findById(userId);

        model.addAttribute("user", user);
        model.addAttribute("shops", shops);
        return "shopList";
    }

    @GetMapping("/shop")
    public String getShop(@RequestParam(name="userId", required = true) long userId,
                          @RequestParam(name="id",required = false,defaultValue = "-1") long shopID,
                          Model model) {

        Shop shop = shopRepository.findById(shopID);
        User user = userRepository.findById(userId);

        model.addAttribute("user", user);
        model.addAttribute("shop", shop);

        return "shopUser";
    }



    @GetMapping("/goManaging")
    public String goManaging(@RequestParam(name="userId", required = true) long userId, Model model){

        User user = userRepository.findById(userId);
        model.addAttribute("user", user);
        model.addAttribute("shop", new Shop("",""));

        return "manager";
    }

    @GetMapping("/welcome")
    public String WelcomeView(@RequestParam(name="userId", required = true) long userId, Model model){

        User user = userRepository.findById(userId);
        model.addAttribute("user", user);

        return "welcome";
    }

}
