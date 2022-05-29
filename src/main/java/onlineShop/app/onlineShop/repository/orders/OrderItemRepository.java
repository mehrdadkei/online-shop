package onlineShop.app.onlineShop.repository.orders;

import onlineShop.app.onlineShop.entities.orders.Invoice;
import onlineShop.app.onlineShop.entities.orders.OrderItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem,Long> {
}
