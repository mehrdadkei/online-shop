package onlineShop.app.onlineShop.repository.product;

import onlineShop.app.onlineShop.entities.product.Feature;
import onlineShop.app.onlineShop.entities.product.Size;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends PagingAndSortingRepository<Size,Long> {
}
