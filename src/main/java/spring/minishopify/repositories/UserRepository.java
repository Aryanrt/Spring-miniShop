package spring.minishopify.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring.minishopify.models.Cart;
import spring.minishopify.models.User;

@RepositoryRestResource(collectionResourceRel = "Users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long>{
    User findByUsername(String username);
    User findById(long id);

}

