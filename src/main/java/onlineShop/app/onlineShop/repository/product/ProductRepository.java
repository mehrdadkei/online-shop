package onlineShop.app.onlineShop.repository.product;

import onlineShop.app.onlineShop.entities.product.Product;
import onlineShop.app.onlineShop.entities.product.ProductCategory;
import onlineShop.app.onlineShop.entities.site.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
   @Query("from Product where category.id = : categoryId")
    List<Product>findAllByCategory(Long categoryId);

   @Query("from Product where enable = true and (title like concat('%',:search,'%') or description like concat('%',:search,'%') )")
   List<Product>findAllByEnableIsTrueAndTitleContainsOrDescriptionContains(String search);
}
