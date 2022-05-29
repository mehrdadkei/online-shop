package onlineShop.app.onlineShop.repository.product;

import onlineShop.app.onlineShop.entities.product.Feature;
import onlineShop.app.onlineShop.entities.product.ProductCategory;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory,Long> {
    List<ProductCategory> findAllByEnableIsTrue(Sort sort);
}
