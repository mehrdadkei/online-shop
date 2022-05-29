package onlineShop.app.onlineShop.repository.people;

import onlineShop.app.onlineShop.entities.people.Customer;
import onlineShop.app.onlineShop.entities.product.Color;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}
