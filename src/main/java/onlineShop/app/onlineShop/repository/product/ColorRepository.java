package onlineShop.app.onlineShop.repository.product;

import onlineShop.app.onlineShop.entities.product.Color;
import onlineShop.app.onlineShop.entities.product.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends PagingAndSortingRepository<Color,Long> {
}
