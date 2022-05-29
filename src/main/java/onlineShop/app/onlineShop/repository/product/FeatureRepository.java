package onlineShop.app.onlineShop.repository.product;

import onlineShop.app.onlineShop.entities.product.Feature;
import onlineShop.app.onlineShop.entities.product.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends PagingAndSortingRepository<Feature,Long> {
}
