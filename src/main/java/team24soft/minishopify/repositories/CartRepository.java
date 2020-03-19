package team24soft.minishopify.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import team24soft.minishopify.models.Cart;
import team24soft.minishopify.models.Shop;

@RepositoryRestResource(collectionResourceRel = "cart", path = "cart")
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {

    Cart findById(long id);
}