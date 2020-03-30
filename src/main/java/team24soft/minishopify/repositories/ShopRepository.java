package team24soft.minishopify.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import team24soft.minishopify.models.Shop;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "shops", path = "shops")
public interface ShopRepository extends PagingAndSortingRepository<Shop, Long> {

   // Shop findById(long id);
    Shop findByName(String name);

    List<Shop> findByCategoryOrName(String category, String name);
}