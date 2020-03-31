package team24soft.minishopify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import team24soft.minishopify.models.Product;
import team24soft.minishopify.models.Shop;
import team24soft.minishopify.repositories.ProductRepository;
import team24soft.minishopify.repositories.ShopRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class MinishopifyApplication {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(MinishopifyApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            ArrayList<String> names = new ArrayList<String>(Arrays.asList("Adidas", "Nike", "HP", "Samsung", "Asus", "Coca-Cola", "Pepsi", "Halls", "Excel", "Albanese"));
            ArrayList<String> categories = new ArrayList<String>(Arrays.asList("sports", "sports", "electronics", "electronics", "electronics", "drinks", "drinks", "candy", "candy", "candy"));
            ArrayList<String> descriptions = new ArrayList<String>(Arrays.asList("Adidas Sports", "Just Do It", "Best Computers", "Best Cellphones", "Best Monitors", "Just Drink it", "Pepsi Cola", "Fresh candies", "Excellent candies", "Delicious chocolate"));


            for (int i = 0; i < names.size(); i++) {
                Shop shop = new Shop(names.get(i), categories.get(i));
                shop.setDescription(descriptions.get(i));

                for (int j = 0; j < 10; j++) {
                    Product product = new Product("Product " + j, names.get(i) + " Product " + j, this.RandomNumber(1, 10), this.RandomNumber(50, 100));
                    shop.addProduct(product);
                    productRepository.save(product);
                }


                shopRepository.save(shop);
            }
        };
    }

    private long RandomNumber(int min, int max) {
        Random r = new Random();

        return r.nextInt(max - min) + min;
    }


}