package team24soft.minishopify.repositories;

import team24soft.minishopify.models.BuddyInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "buddies", path = "buddies")
public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Long> {
    BuddyInfo findByLastName(String lastName);
    BuddyInfo findByPhone(String phone);
    BuddyInfo findById(long id);
}