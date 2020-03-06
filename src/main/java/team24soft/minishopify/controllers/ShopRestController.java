//package team24soft.minishopify.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.view.RedirectView;
//import team24soft.minishopify.models.Shop;
//import team24soft.minishopify.repositories.ShopRepository;
//
//@RestController()
//public class ShopRestController {
//
//    @Autowired
//    ShopRepository shopRepository;
//
//
//    @GetMapping("/createShop")
//    public Shop createBook(@RequestParam(name="name", required = false,defaultValue = "name") String name,
//                           @RequestParam(name="category", required = false,defaultValue = "category") String category){
//
//        Shop shop = new Shop(name, category);
//
//        shopRepository.save(shop);
//
//        return shop;
//    }
//
//
//}