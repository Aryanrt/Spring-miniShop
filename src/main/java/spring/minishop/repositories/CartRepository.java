package spring.minishop.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring.minishop.models.Cart;

@RepositoryRestResource(collectionResourceRel = "cart", path = "cart")
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {

    Cart findById(long id);
}