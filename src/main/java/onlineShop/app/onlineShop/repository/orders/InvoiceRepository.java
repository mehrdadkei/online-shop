package onlineShop.app.onlineShop.repository.orders;

import onlineShop.app.onlineShop.entities.orders.Invoice;
import onlineShop.app.onlineShop.entities.people.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice,Long> {
    @Query("from Invoice where customer.id = :customerId")
    List<Invoice>findAllByCustomer(long customer);
}
