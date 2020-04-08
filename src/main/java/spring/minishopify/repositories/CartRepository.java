package spring.minishopify.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring.minishopify.models.Cart;
import spring.minishopify.models.Shop;

@RepositoryRestResource(collectionResourceRel = "cart", path = "cart")
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {

    Cart findById(long id);
}