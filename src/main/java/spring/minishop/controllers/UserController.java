package spring.minishop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.minishop.models.Shop;
import spring.minishop.repositories.CartRepository;
import spring.minishop.repositories.ProductRepository;
import spring.minishop.repositories.ShopRepository;
import spring.minishop.repositories.UserRepository;
import spring.minishop.models.Category;
import spring.minishop.models.User;

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

        if(filter.equals("")){
            shops.addAll((List<Shop>)shopRepository.findAll());
        }
        else {
            if(shopRepository.findByName(filter) != null)
                shops.add(shopRepository.findByName(filter));

            for (Shop shop : shopRepository.findAll())
                if (shop.getCategory().toString().equalsIgnoreCase(filter) )
                    shops.add(shop);

        }

        User user = userRepository.findById(userId);

        model.addAttribute("user", user);
        model.addAttribute("shops", shops);
        return "shopList";
    }

    @GetMapping("/shop")
    public String getShop(@RequestParam(name="userId", required = true) long userId,
                          @RequestParam(name="shopName") String shopName,
                          Model model) {

        Shop shop = shopRepository.findByName(shopName);
        User user = userRepository.findById(userId);

        model.addAttribute("user", user);
        model.addAttribute("shop", shop);

        return "shopUser";
    }



    @GetMapping("/goManaging")
    public String goManaging(@RequestParam(name="userId", required = true) long userId, Model model){

        User user = userRepository.findById(userId);
        model.addAttribute("user", user);
        model.addAttribute("shop", new Shop("", Category.Books));

        return "manager";
    }

    @GetMapping("/welcome")
    public String WelcomeView(@RequestParam(name="userId", required = true) long userId, Model model){

        User user = userRepository.findById(userId);
        model.addAttribute("user", user);

        return "welcome";
    }

}
