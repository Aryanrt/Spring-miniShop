package team24soft.minishopify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team24soft.minishopify.models.Product;
import team24soft.minishopify.models.Shop;
import team24soft.minishopify.repositories.ProductRepository;
import team24soft.minishopify.repositories.ShopRepository;

import java.time.Period;

@Controller()
public class shopMVCController {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ProductRepository productRepository;

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
                           @RequestParam(name="price", required = false, defaultValue = "0") int price,
                           @RequestParam(name="inventory", required = false, defaultValue = "0") int inventory,
                           Model model){


        Product product = new Product(name,description,price);

        product.setInventoryNumber(inventory);

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


}
