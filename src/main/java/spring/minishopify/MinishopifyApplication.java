package spring.minishopify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.minishopify.models.Category;
import spring.minishopify.models.Product;
import spring.minishopify.models.Shop;
import spring.minishopify.repositories.ProductRepository;
import spring.minishopify.repositories.ShopRepository;

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
            ArrayList<String> categories = new ArrayList<String>(Arrays.asList("Sports", "Sports", "Electronics", "Electronics", "Electronics", "Drinks", "Drinks", "Candy", "Candy", "Candy"));
            ArrayList<String> descriptions = new ArrayList<String>(Arrays.asList("Adidas Sports", "Just Do It", "Best Computers", "Best Cellphones", "Best Monitors", "Just Drink it", "Pepsi Cola", "Fresh candies", "Excellent candies", "Delicious chocolate"));


            for (int i = 0; i < names.size(); i++) {
                Shop shop = new Shop(names.get(i), Category.valueOf(categories.get(i)));
                shop.setDescription(descriptions.get(i));

                for (int j = 0; j < 10; j++) {
                    Product product = new Product("Product " + j, names.get(i) + " Product " + j, this.RandomNumber(2, 10), this.RandomNumber(50, 100));
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