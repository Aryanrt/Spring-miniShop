package team24soft.minishopify.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import team24soft.minishopify.models.Product;


@RepositoryRestResource(collectionResourceRel = "products", path = "prodcuts")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Product findByTitle(String title);
    Product findByPrice(int price);
    Product findByInventoryNumber(long inventoryNumber);
}