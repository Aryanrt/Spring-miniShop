package team24soft.minishopify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import team24soft.minishopify.models.Product;
import team24soft.minishopify.models.Shop;
import team24soft.minishopify.repositories.ProductRepository;
import team24soft.minishopify.repositories.ShopRepository;

import java.util.LinkedList;

@RestController()
public class ShopController {

    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/createStore")
    public Shop createStore(@RequestParam(name="name", required = false,defaultValue = "name") String name,
                           @RequestParam(name="category", required = false,defaultValue = "category") String category){

        //System.out.println("hhhhhhhhhh");
        Shop shop = new Shop(name, category);
        //System.out.println(shop.getId());
        shopRepository.save(shop);
        //System.out.println(shop.id);
        //System.out.println(shopRepository.findById(0));

        return shop;
    }

    //@RequestMapping("/addressBook")
    @GetMapping("/showShop")
    public LinkedList<Shop> showShop(){
        Shop shop=null;
        LinkedList<Shop> shops= new LinkedList<Shop>();
        int i;
        for(i = 1 ;; i++)
        {
            if(shopRepository.findById(i) == null) {
                if(shopRepository.findById(i-1).getProducts().size() > 0 )
                    i += (shopRepository.findById(i-1).getProducts().size() - 1);

                else
                    break;
            }


            shops.add(shopRepository.findById(i));

        }
        return shops;
    }

    @GetMapping("/addProduct")
    public RedirectView addProduct(@RequestParam(name="title", required = false,defaultValue = "1") String name,
                                 @RequestParam(name="description", required = false,defaultValue = "") String description,
                                 @RequestParam(name= "quantity", required = false,defaultValue = "") int quantity,
                                 @RequestParam(name= "price", required = false,defaultValue = "") Long price){

        Shop shop;
        if(shopRepository.findById(1) == null)
            shop = new Shop(" ", " ");
        else
            shop = shopRepository.findById(1);

        shopRepository.save(shop);
        //System.out.println("id is: " +shop.getId());

        Product buddy = new Product(name,description,quantity,price);

        shop.addProduct(buddy);

        productRepository.save(buddy);
        shopRepository.save(shop);

        //return "redirect: /index.html";
        return new RedirectView("");

    }


}