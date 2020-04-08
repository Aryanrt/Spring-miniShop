package spring.minishopify.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring.minishopify.models.Shop;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "shops", path = "shops")
public interface ShopRepository extends PagingAndSortingRepository<Shop, Long> {
    Shop findByName(String name);
}