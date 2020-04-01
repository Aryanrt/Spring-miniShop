package spring.minishop.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring.minishop.models.Product;


@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Product findByTitle(String title);
    Product findByPrice(int price);
    Product findByInventoryNumber(long inventoryNumber);
}