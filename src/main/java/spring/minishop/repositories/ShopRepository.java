package spring.minishop.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import spring.minishop.models.Shop;

@RepositoryRestResource(collectionResourceRel = "shops", path = "shops")
public interface ShopRepository extends PagingAndSortingRepository<Shop, Long> {
    Shop findByName(String name);
}