package team24soft.minishopify.repositories;


import team24soft.minishopify.models.AddressBook;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long> {

    AddressBook findById(long id);

}